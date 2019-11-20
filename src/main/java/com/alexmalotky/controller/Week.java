package com.alexmalotky.controller;

import com.alexmalotky.entity.Calendar;
import com.alexmalotky.entity.User;
import com.alexmalotky.util.LoginServlet;
import com.alexmalotky.util.NotLoggedInException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.DayOfWeek;
import java.time.*;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

@WebServlet( urlPatterns = {"/Week"} )
public class Week extends LoginServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
        @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter dom = response.getWriter();
        response.setContentType("application/json");

        try
        {
            String json = "{ ";
            User u = getLoggedInUser(request);
            Set<Calendar> calendars = u.getCalendar();
            long date = getDate(request);
            LocalDate start = getStartOfWeek(date);
            LocalDate end = start.plusDays(6);

            json += "\"start\":" + convertToDate(start) + ", ";

            json += "\"list\":[ ";
            for (Iterator<Calendar> it = calendars.iterator(); it.hasNext(); ){
                Calendar c = it.next();
                LocalDate event = c.getLocalDate();
                if( !(event.isBefore(start) || event.isAfter(end)) ){
                    json += "{\"date\":" + c.getDate() + " ,\"recipe\": " +
                            "{ \"id\":" + c.getRecipe().getId() + " ,\"name\":\"" + c.getRecipe().getName() + "\", " +
                            "\"ingredients\":" + c.getRecipe().getIngredients() + "}}";

                    if( it.hasNext() )
                        json += ", ";
                }
            }
            json += "]}";

            dom.write(json);
        } catch (NotLoggedInException e) {
            response.setStatus(401);
            dom.write("Access is denied!");
        } catch (Exception e) {
            response.setStatus(500);
            dom.write(e.getMessage());
            e.printStackTrace();
        }
    }

    private long getDate(HttpServletRequest request) {
        String input = request.getParameter("date");

        if(input == null)
            return new Date().getTime();

        return Long.parseLong(input);
    }

    private LocalDate getStartOfWeek(long time) {
        LocalDate date = LocalDate.ofInstant(new Date(time).toInstant(), ZoneId.systemDefault());

        while(date.getDayOfWeek() != DayOfWeek.SUNDAY)
            date = date.minusDays(1);

        return date;
    }

    private long convertToDate(LocalDate date) {
        ZoneId id = ZoneId.of("GMT");
        Date output = Date.from(date.atStartOfDay(id).toInstant());
        return output.getTime();
    }
}

package com.alexmalotky.controller;

import com.alexmalotky.entity.Calendar;
import com.alexmalotky.entity.User;
import com.alexmalotky.util.LoginServlet;
import com.alexmalotky.util.NotLoggedInException;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.DayOfWeek;
import java.time.*;
import java.util.Date;
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
            JSONObject json = new JSONObject();
            User u = getLoggedInUser(request);
            Set<Calendar> calendars = u.getCalendar();
            long date = getDate(request);
            LocalDate start = getStartOfWeek(date);
            LocalDate end = start.plusDays(6);

            json.put("start", convertToDate(start));

            JSONArray list = new JSONArray();
            for (Calendar c : calendars){
                LocalDate event = c.getLocalDate();
                if( !(event.isBefore(start) || event.isAfter(end)) ){
                    JSONObject calendar = new JSONObject();
                    JSONObject recipe = new JSONObject();

                    recipe.put("id", c.getRecipe().getId());
                    recipe.put("name", c.getRecipe().getName());
                    recipe.put("ingredients", new JSONArray(c.getRecipe().getIngredients()));

                    calendar.put("date", c.getDate());
                    calendar.put("recipe", recipe);

                    list.put(calendar);
                }
            }

            json.put("list", list);

            dom.write(json.toString());
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

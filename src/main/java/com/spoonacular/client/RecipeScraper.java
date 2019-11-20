package com.spoonacular.client;

import com.alexmalotky.entity.Recipe;
import com.alexmalotky.entity.Volume;
import com.alexmalotky.entity.Weight;
import com.alexmalotky.util.PasswordManager;
import com.alexmalotky.util.Units;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spoonacular.entity.AnalyzedInstructionsItem;
import com.spoonacular.entity.ExtendedIngredientsItem;
import com.spoonacular.entity.ResponseRecipe;
import com.spoonacular.entity.StepsItem;
import com.spoonacular.util.Ingredient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Iterator;
import java.util.List;

public class RecipeScraper {

    private String key = "550d3ba1323940b099b7ad98aa4bbdc6";
    private String api = "https://api.spoonacular.com/recipes/extract";
    private Units units = new Units();

    private static final Logger logger = LogManager.getLogger(PasswordManager.class);

    public Recipe get(String targetUrl) {
        String url = api + "?apiKey=" + key + "&url=" + targetUrl;

        try {
            ResponseRecipe response = run(url);

            return new Recipe(response.getTitle(),
                            parseIngredients(response.getExtendedIngredients()),
                            parseInstructions(response.getAnalyzedInstructions()));
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    private ResponseRecipe run(String url) throws Exception {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(url);
        Response response = target.request(MediaType.APPLICATION_JSON).get();

        if(response.getStatus() != 200)
            throw new Exception("Scraping service is currently unavailable");

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(response.readEntity(String.class), ResponseRecipe.class);
    }

    private String parseIngredients(List<ExtendedIngredientsItem> list) {
        String output = "[";
        for(Iterator<ExtendedIngredientsItem> it = list.iterator(); it.hasNext();) {
            ExtendedIngredientsItem item = it.next();
            Ingredient ingredient = new Ingredient(item.getAmount(),
                            getCode(item.getUnit()),
                            item.getName());

            output += ingredient.toJson();
            if(it.hasNext())
                output += ",";
        }

        return output + "]";
    }

    private String parseInstructions(List<AnalyzedInstructionsItem> list) {
        String output = "[";
        for(Iterator<AnalyzedInstructionsItem> it = list.iterator(); it.hasNext();) {
            AnalyzedInstructionsItem item = it.next();
            output += parseSteps(item.getSteps());

            if(it.hasNext())
                output += ", ";
        }

        return output + "]";
    }

    private String parseSteps(List<StepsItem> list) {
        String output = "";
        for(Iterator<StepsItem> it = list.iterator(); it.hasNext();) {
            StepsItem item = it.next();
            output += '"' + item.getStep() + '"';

            if(it.hasNext())
                output += ", ";
        }

        return output;
    }

    private String getCode(String unit) {
        for(Volume v: units.getVolumes()) {
            String test = v.getName();
            if(test.toUpperCase().contains(unit.toUpperCase()) ||
                    unit.toUpperCase().contains(test.toUpperCase()) )
                return v.getCode();
        }

        for(Weight w: units.getWeights()) {
            String test = w.getName();
            if(test.toUpperCase().contains(unit.toUpperCase()) ||
                unit.toUpperCase().contains(test.toUpperCase()) )
                return w.getCode();
        }

        return unit;
    }
}

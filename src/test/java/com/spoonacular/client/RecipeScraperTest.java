package com.spoonacular.client;

import com.alexmalotky.entity.Recipe;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecipeScraperTest {

    private String expected = "Recipe{id=0, name='Chocolate Crinkle Cookies', ingredients='[{\"amount\":2.3333333333333335, \"unit\":\"cup\", \"item\":\"flour\"},{\"amount\":2.0, \"unit\":\"teaspoons\", \"item\":\"baking powder\"},{\"amount\":0.25, \"unit\":\"teaspoon\", \"item\":\"salt\"},{\"amount\":1.5, \"unit\":\"cups\", \"item\":\"sugar\"},{\"amount\":0.25, \"unit\":\"cup\", \"item\":\"brown sugar\"},{\"amount\":0.75, \"unit\":\"cup\", \"item\":\"vegetable oil\"},{\"amount\":4.0, \"unit\":\"\", \"item\":\"eggs\"},{\"amount\":2.5, \"unit\":\"teaspoons\", \"item\":\"vanilla extract\"},{\"amount\":1.0, \"unit\":\"cup\", \"item\":\"cocoa powder\"},{\"amount\":0.5, \"unit\":\"cup\", \"item\":\"confectioners sugar\"}]', directions='[\"Preheat the oven to 350 degrees F. Like two baking sheets with parchment paper and set aside.\", \"In a small mixing bowl add the flour, baking powder and salt.\", \"Mix well and set aside.\", \"In the bowl of a kitchen mixer, such as a Kitchen\", \"Aid, fitted with a paddle attachment, add the sugar and oil and mix well.\", \"Add the eggs and vanilla extract and blend until well incorporated.\", \"Add the cocoa and the flour mixture and blend well.\", \"Place the confectioners sugar in a small shallow bowl and place by your work station.\", \"Using your hands, scoop out some dough and roll into a ball about an inch or so in diameter. (Feel free to make these are smaller or larger depending on your preference but note, the cooking time will change slightly).\", \"Roll the dough in the confectioners sugar and place on the prepared baking sheet.\", \"Bake for about 10 minutes and cookies are slightly puffed. Cool slightly and serve. Note: Because this is an oil-based cookie, the dough can get soft quickly, so be sure to refrigerate any dough you are not using right away.\"]',user=null}";

    @Test
    @Disabled
    void getTest() {

        String url = "https://foodista.com/recipe/ZHK4KPB6/chocolate-crinkle-cookies";

        RecipeScraper test = new RecipeScraper();
        Recipe r = test.get(url);

        assertEquals(expected, r.toString());
    }
}
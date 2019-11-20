package com.alexmalotky.util;

import com.alexmalotky.entity.Volume;
import com.alexmalotky.entity.Weight;
import com.spoonacular.util.Ingredient;

import java.util.List;

/*public class IngredientsList {
    List<Ingredient> list;
    Units units = new Units();

    Ingredient find(Ingredient ingredient){
        for( Ingredient i: list) {
            if(i.getItem() == ingredient.getItem()) {
                if( checkWeight(i.getUnit(), ingredient.getUnit()) ||
                        checkVolume(i.getUnit(), ingredient.getUnit()) )
                    return i;
            }
        }

        return null;
    }

    boolean checkWeight(String lhs, String rhs) {
        if(lhs.equals(rhs))
            return true;

        return (getWeight(lhs) != null) && (getWeight(rhs) != null);
    }

    Weight getWeight(String code) {
        for( Weight u: units.getWeights() ){
            if(code.equals(u.getCode()))
                return u;
        }

        return null;
    }

    boolean checkVolume(String lhs, String rhs) {
        if(lhs.equals(rhs))
            return true;

        return (getVolume(lhs) != null) && (getVolume(rhs) != null);
    }

    Volume getVolume(String code) {
        for( Volume u: units.getVolumes() ){
            if(code.equals(u.getCode()))
                return u;
        }

        return null;
    }

    void add(Ingredient ingredient) {
        Ingredient i = find(ingredient);

        if(i == null) {
            list.add(ingredient);
        } else {

        }
    }
}
*/
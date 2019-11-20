package com.spoonacular.util;

import org.json.JSONObject;

public class Ingredient {
    private Double amount;
    private String unit;
    private String item;

    public Ingredient() {

    }

    public Ingredient(String json) {
        this( new JSONObject(json) );
    }

    public Ingredient(JSONObject json) {
        this.amount = json.getDouble("amount");
        this.item = json.getString("item");
        this.unit = json.getString("unit");
    }

    public Ingredient(Double amount, String unit, String item) {
        this.amount = amount;
        this.unit = unit;
        this.item = item;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String toJson() {
        return "{" +
                "\"amount\":" + amount +
                ", \"unit\":\"" + unit + '"' +
                ", \"item\":\"" + item + '"' +
                '}';
    }
}

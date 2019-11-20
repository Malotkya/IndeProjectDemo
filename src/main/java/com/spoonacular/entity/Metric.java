package com.spoonacular.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Metric{

	@JsonProperty("amount")
	private double amount;

	@JsonProperty("unitShort")
	private String unitShort;

	@JsonProperty("unitLong")
	private String unitLong;

	public void setAmount(double amount){
		this.amount = amount;
	}

	public double getAmount(){
		return amount;
	}

	public void setUnitShort(String unitShort){
		this.unitShort = unitShort;
	}

	public String getUnitShort(){
		return unitShort;
	}

	public void setUnitLong(String unitLong){
		this.unitLong = unitLong;
	}

	public String getUnitLong(){
		return unitLong;
	}

	@Override
 	public String toString(){
		return 
			"Metric{" + 
			"amount = '" + amount + '\'' + 
			",unitShort = '" + unitShort + '\'' + 
			",unitLong = '" + unitLong + '\'' + 
			"}";
		}
}
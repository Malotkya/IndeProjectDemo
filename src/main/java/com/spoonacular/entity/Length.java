package com.spoonacular.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Length{

	@JsonProperty("number")
	private int number;

	@JsonProperty("unit")
	private String unit;

	public void setNumber(int number){
		this.number = number;
	}

	public int getNumber(){
		return number;
	}

	public void setUnit(String unit){
		this.unit = unit;
	}

	public String getUnit(){
		return unit;
	}

	@Override
 	public String toString(){
		return 
			"Length{" + 
			"number = '" + number + '\'' + 
			",unit = '" + unit + '\'' + 
			"}";
		}
}
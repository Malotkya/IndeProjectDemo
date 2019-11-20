package com.spoonacular.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class StepsItem{

	@JsonProperty("number")
	private int number;

	@JsonProperty("length")
	private Length length;

	@JsonProperty("ingredients")
	private List<Object> ingredients;

	@JsonIgnore
	@JsonProperty("equipment")
	private List<EquipmentItem> equipment;

	@JsonProperty("step")
	private String step;

	public void setNumber(int number){
		this.number = number;
	}

	public int getNumber(){
		return number;
	}

	public void setLength(Length length){
		this.length = length;
	}

	public Length getLength(){
		return length;
	}

	public void setIngredients(List<Object> ingredients){
		this.ingredients = ingredients;
	}

	public List<Object> getIngredients(){
		return ingredients;
	}

	public void setEquipment(List<EquipmentItem> equipment){
		this.equipment = equipment;
	}

	public List<EquipmentItem> getEquipment(){
		return equipment;
	}

	public void setStep(String step){
		this.step = step;
	}

	public String getStep(){
		return step;
	}

	@Override
 	public String toString(){
		return 
			"StepsItem{" + 
			"number = '" + number + '\'' + 
			",length = '" + length + '\'' + 
			",ingredients = '" + ingredients + '\'' + 
			",equipment = '" + equipment + '\'' + 
			",step = '" + step + '\'' + 
			"}";
		}
}
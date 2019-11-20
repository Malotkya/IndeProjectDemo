package com.spoonacular.entity;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class ExtendedIngredientsItem{

	@JsonProperty("image")
	private String image;

	@JsonProperty("amount")
	private double amount;

	@JsonProperty("original")
	private String original;

	@JsonProperty("consitency")
	private String consitency;

	@JsonProperty("aisle")
	private String aisle;

	@JsonProperty("originalName")
	private String originalName;

	@JsonProperty("unit")
	private String unit;

	@JsonProperty("measures")
	private Measures measures;

	@JsonProperty("meta")
	private List<String> meta;

	@JsonProperty("name")
	private String name;

	@JsonProperty("originalString")
	private String originalString;

	@JsonProperty("id")
	private int id;

	@JsonProperty("metaInformation")
	private List<String> metaInformation;

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	public void setAmount(double amount){
		this.amount = amount;
	}

	public double getAmount(){
		return amount;
	}

	public void setOriginal(String original){
		this.original = original;
	}

	public String getOriginal(){
		return original;
	}

	public void setConsitency(String consitency){
		this.consitency = consitency;
	}

	public String getConsitency(){
		return consitency;
	}

	public void setAisle(String aisle){
		this.aisle = aisle;
	}

	public String getAisle(){
		return aisle;
	}

	public void setOriginalName(String originalName){
		this.originalName = originalName;
	}

	public String getOriginalName(){
		return originalName;
	}

	public void setUnit(String unit){
		this.unit = unit;
	}

	public String getUnit(){
		return unit;
	}

	public void setMeasures(Measures measures){
		this.measures = measures;
	}

	public Measures getMeasures(){
		return measures;
	}

	public void setMeta(List<String> meta){
		this.meta = meta;
	}

	public List<String> getMeta(){
		return meta;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setOriginalString(String originalString){
		this.originalString = originalString;
	}

	public String getOriginalString(){
		return originalString;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setMetaInformation(List<String> metaInformation){
		this.metaInformation = metaInformation;
	}

	public List<String> getMetaInformation(){
		return metaInformation;
	}

	@Override
 	public String toString(){
		return 
			"ExtendedIngredientsItem{" + 
			"image = '" + image + '\'' + 
			",amount = '" + amount + '\'' + 
			",original = '" + original + '\'' + 
			",consitency = '" + consitency + '\'' + 
			",aisle = '" + aisle + '\'' + 
			",originalName = '" + originalName + '\'' + 
			",unit = '" + unit + '\'' + 
			",measures = '" + measures + '\'' + 
			",meta = '" + meta + '\'' + 
			",name = '" + name + '\'' + 
			",originalString = '" + originalString + '\'' + 
			",id = '" + id + '\'' + 
			",metaInformation = '" + metaInformation + '\'' + 
			"}";
		}
}
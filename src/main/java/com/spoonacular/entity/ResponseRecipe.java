package com.spoonacular.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;


@Generated("com.robohorse.robopojogenerator")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseRecipe {

	@JsonProperty("instructions")
	private String instructions;

	@JsonProperty("sustainable")
	private boolean sustainable;

	@JsonProperty("analyzedInstructions")
	private List<AnalyzedInstructionsItem> analyzedInstructions;

	@JsonProperty("glutenFree")
	private boolean glutenFree;

	@JsonProperty("veryPopular")
	private boolean veryPopular;

	@JsonProperty("healthScore")
	private int healthScore;

	@JsonProperty("title")
	private String title;

	@JsonProperty("diets")
	private List<Object> diets;

	@JsonProperty("aggregateLikes")
	private int aggregateLikes;

	@JsonProperty("sourceUrl")
	private String sourceUrl;

	@JsonProperty("creditsText")
	private Object creditsText;

	@JsonProperty("dairyFree")
	private boolean dairyFree;

	@JsonProperty("servings")
	private int servings;

	@JsonProperty("vegetarian")
	private boolean vegetarian;

	@JsonProperty("whole30")
	private boolean whole30;

	@JsonProperty("id")
	private int id;

	@JsonProperty("imageType")
	private String imageType;

	@JsonProperty("winePairing")
	private WinePairing winePairing;

	@JsonProperty("image")
	private String image;

	@JsonProperty("veryHealthy")
	private boolean veryHealthy;

	@JsonProperty("vegan")
	private boolean vegan;

	@JsonProperty("cheap")
	private boolean cheap;

	@JsonProperty("extendedIngredients")
	private List<ExtendedIngredientsItem> extendedIngredients;

	@JsonProperty("dishTypes")
	private List<Object> dishTypes;

	@JsonProperty("gaps")
	private String gaps;

	@JsonProperty("cuisines")
	private List<Object> cuisines;

	@JsonProperty("lowFodmap")
	private boolean lowFodmap;

	@JsonProperty("weightWatcherSmartPoints")
	private int weightWatcherSmartPoints;

	@JsonProperty("occasions")
	private List<Object> occasions;

	@JsonProperty("spoonacularScore")
	private int spoonacularScore;

	@JsonProperty("pricePerServing")
	private int pricePerServing;

	@JsonProperty("sourceName")
	private Object sourceName;

	@JsonProperty("ketogenic")
	private boolean ketogenic;

	public void setInstructions(String instructions){
		this.instructions = instructions;
	}

	public String getInstructions(){
		return instructions;
	}

	public void setSustainable(boolean sustainable){
		this.sustainable = sustainable;
	}

	public boolean isSustainable(){
		return sustainable;
	}

	public void setAnalyzedInstructions(List<AnalyzedInstructionsItem> analyzedInstructions){
		this.analyzedInstructions = analyzedInstructions;
	}

	public List<AnalyzedInstructionsItem> getAnalyzedInstructions(){
		return analyzedInstructions;
	}

	public void setGlutenFree(boolean glutenFree){
		this.glutenFree = glutenFree;
	}

	public boolean isGlutenFree(){
		return glutenFree;
	}

	public void setVeryPopular(boolean veryPopular){
		this.veryPopular = veryPopular;
	}

	public boolean isVeryPopular(){
		return veryPopular;
	}

	public void setHealthScore(int healthScore){
		this.healthScore = healthScore;
	}

	public int getHealthScore(){
		return healthScore;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setDiets(List<Object> diets){
		this.diets = diets;
	}

	public List<Object> getDiets(){
		return diets;
	}

	public void setAggregateLikes(int aggregateLikes){
		this.aggregateLikes = aggregateLikes;
	}

	public int getAggregateLikes(){
		return aggregateLikes;
	}

	public void setSourceUrl(String sourceUrl){
		this.sourceUrl = sourceUrl;
	}

	public String getSourceUrl(){
		return sourceUrl;
	}

	public void setCreditsText(Object creditsText){
		this.creditsText = creditsText;
	}

	public Object getCreditsText(){
		return creditsText;
	}

	public void setDairyFree(boolean dairyFree){
		this.dairyFree = dairyFree;
	}

	public boolean isDairyFree(){
		return dairyFree;
	}

	public void setServings(int servings){
		this.servings = servings;
	}

	public int getServings(){
		return servings;
	}

	public void setVegetarian(boolean vegetarian){
		this.vegetarian = vegetarian;
	}

	public boolean isVegetarian(){
		return vegetarian;
	}

	public void setWhole30(boolean whole30){
		this.whole30 = whole30;
	}

	public boolean isWhole30(){
		return whole30;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setImageType(String imageType){
		this.imageType = imageType;
	}

	public String getImageType(){
		return imageType;
	}

	public void setWinePairing(WinePairing winePairing){
		this.winePairing = winePairing;
	}

	public WinePairing getWinePairing(){
		return winePairing;
	}

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	public void setVeryHealthy(boolean veryHealthy){
		this.veryHealthy = veryHealthy;
	}

	public boolean isVeryHealthy(){
		return veryHealthy;
	}

	public void setVegan(boolean vegan){
		this.vegan = vegan;
	}

	public boolean isVegan(){
		return vegan;
	}

	public void setCheap(boolean cheap){
		this.cheap = cheap;
	}

	public boolean isCheap(){
		return cheap;
	}

	public void setExtendedIngredients(List<ExtendedIngredientsItem> extendedIngredients){
		this.extendedIngredients = extendedIngredients;
	}

	public List<ExtendedIngredientsItem> getExtendedIngredients(){
		return extendedIngredients;
	}

	public void setDishTypes(List<Object> dishTypes){
		this.dishTypes = dishTypes;
	}

	public List<Object> getDishTypes(){
		return dishTypes;
	}

	public void setGaps(String gaps){
		this.gaps = gaps;
	}

	public String getGaps(){
		return gaps;
	}

	public void setCuisines(List<Object> cuisines){
		this.cuisines = cuisines;
	}

	public List<Object> getCuisines(){
		return cuisines;
	}

	public void setLowFodmap(boolean lowFodmap){
		this.lowFodmap = lowFodmap;
	}

	public boolean isLowFodmap(){
		return lowFodmap;
	}

	public void setWeightWatcherSmartPoints(int weightWatcherSmartPoints){
		this.weightWatcherSmartPoints = weightWatcherSmartPoints;
	}

	public int getWeightWatcherSmartPoints(){
		return weightWatcherSmartPoints;
	}

	public void setOccasions(List<Object> occasions){
		this.occasions = occasions;
	}

	public List<Object> getOccasions(){
		return occasions;
	}

	public void setSpoonacularScore(int spoonacularScore){
		this.spoonacularScore = spoonacularScore;
	}

	public int getSpoonacularScore(){
		return spoonacularScore;
	}

	public void setPricePerServing(int pricePerServing){
		this.pricePerServing = pricePerServing;
	}

	public int getPricePerServing(){
		return pricePerServing;
	}

	public void setSourceName(Object sourceName){
		this.sourceName = sourceName;
	}

	public Object getSourceName(){
		return sourceName;
	}

	public void setKetogenic(boolean ketogenic){
		this.ketogenic = ketogenic;
	}

	public boolean isKetogenic(){
		return ketogenic;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"instructions = '" + instructions + '\'' + 
			",sustainable = '" + sustainable + '\'' + 
			",analyzedInstructions = '" + analyzedInstructions + '\'' + 
			",glutenFree = '" + glutenFree + '\'' + 
			",veryPopular = '" + veryPopular + '\'' + 
			",healthScore = '" + healthScore + '\'' + 
			",title = '" + title + '\'' + 
			",diets = '" + diets + '\'' + 
			",aggregateLikes = '" + aggregateLikes + '\'' + 
			",sourceUrl = '" + sourceUrl + '\'' + 
			",creditsText = '" + creditsText + '\'' + 
			",dairyFree = '" + dairyFree + '\'' + 
			",servings = '" + servings + '\'' + 
			",vegetarian = '" + vegetarian + '\'' + 
			",whole30 = '" + whole30 + '\'' + 
			",id = '" + id + '\'' + 
			",imageType = '" + imageType + '\'' + 
			",winePairing = '" + winePairing + '\'' + 
			",image = '" + image + '\'' + 
			",veryHealthy = '" + veryHealthy + '\'' + 
			",vegan = '" + vegan + '\'' + 
			",cheap = '" + cheap + '\'' + 
			",extendedIngredients = '" + extendedIngredients + '\'' + 
			",dishTypes = '" + dishTypes + '\'' + 
			",gaps = '" + gaps + '\'' + 
			",cuisines = '" + cuisines + '\'' + 
			",lowFodmap = '" + lowFodmap + '\'' + 
			",weightWatcherSmartPoints = '" + weightWatcherSmartPoints + '\'' + 
			",occasions = '" + occasions + '\'' + 
			",spoonacularScore = '" + spoonacularScore + '\'' + 
			",pricePerServing = '" + pricePerServing + '\'' + 
			",sourceName = '" + sourceName + '\'' + 
			",ketogenic = '" + ketogenic + '\'' + 
			"}";
		}
}
package com.mycompany.healthfitnessapp;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/** This is the meal plan class in which each individual is given a personalized meal plan to follow in order to satisfy their health.
 * Date: August 20, 2023
 * @author Manvi
 */
//import arraylist class from java library

import java.util.ArrayList;
//import Random class from java library
import java.util.Random;
//import BufferedReader class for reading files from java library
import java.io.BufferedReader;
//import FileReader for readin files class from java library
import java.io.FileReader;
//import IOException class for handling input/output exceptions from java library
import java.io.IOException;

public class MealPlan {
    
    //stores list of recipies
    private ArrayList <String> recipes;
    //stores client information
    private Client client;
    //stores the number of meal sets
    private int mealSets;
    //provides path to the recipe file
    private static final String FILE_PATH = "Recipe.txt";
    
    //constructor to initialize MealPlan
    public MealPlan(Client client, String filePath, int mealSets){
        //set the client, read recipes from file , and set the number of mealSets
        this.client = client;
        this.recipes = readRecipesFromFile(filePath); 
        this.mealSets = mealSets;
    } 
    
    //method to read recipes from file and return them as an ArrayList
    private ArrayList <String> readRecipesFromFile(String filePath) {
        //initialize arrayList to store recipies
        ArrayList <String> recipes = new ArrayList<>();
        
        try {
            //create reader for the file
            BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
            //variable to hold each line of the file
            String line;
            //StringBuilder to build each recipe 
            StringBuilder recipeBuilder = new StringBuilder();
            //read each line from the file
            while((line = reader.readLine()) != null) {
                //if a blank line is found
                if (line.isEmpty()) {
                    //check if a recipe has been collected
                    if (recipeBuilder.length() > 0) {
                        //add collected recipe to the list
                        recipes.add(recipeBuilder.toString());
                        //reset the recipeBuilder for next recipe
                        recipeBuilder.setLength(0);
                    }
                } else {
                    //add the line to the recipeBuilder
                    recipeBuilder.append(line).append("\n");
                }
            } 
            //check if a recipe is left in the builder
            if (recipeBuilder.length() > 0) {
                //add the reamaining recipe to the list
                recipes.add(recipeBuilder.toString());
            }
            //close the reader
            reader.close();
        } catch (IOException e) {
             //catches and handles exceptions and rpints error if reading fails
            e.printStackTrace();
        } 
        //return list of recipes
        return recipes;
    } 
    
    //method to get dietary tag from recipe string
    private String getDietTag(String recipe) {
        //find start index of dietary tag
        int startIndex = recipe.indexOf("Dietary Tags:") + 14;
        //find the end index of the dietary tag
        int endIndex = recipe.indexOf('\n', startIndex);
        //extract and return the dietary tag
        return recipe.substring(startIndex, endIndex);
        
    } 
    
    //method to get calories from recipe string
    private double getCalories(String recipe) {
        //find the start index of the calories
        int startIndex = recipe.indexOf("Calories:") + 9;
        //find the end index of calories
        int endIndex = recipe.indexOf('\n', startIndex);
        //extract and parse the calories
        return Double.parseDouble(recipe.substring(startIndex, endIndex));
    } 
    
    //method to generate a list of suggested meals based on client's preferences
    private ArrayList <String> suggestMeals(Client client) {
        //initialize arrayList to store suggested meals
        ArrayList <String> suggestedMeals = new ArrayList<>();
        //create random object
        Random random = new Random(); 
        //array of meal categories
        String [] categories = {"Breakfast", "Lunch", "Dinner"}; 
        //Stringbuilder to build each meal set
        StringBuilder mealSetBuilder = new StringBuilder();
        //loop through meal categories (breakfast, lunch, dinner)
        for (String category: categories) {
            //create a new list to store valid recipes for the current category
            ArrayList <String> validRecipes = new ArrayList<>(); 
            //repeat through each recipe in the list of recipes
            for (String recipe: recipes) {
                //check if the recipe's category matches the current category and the client's diet preferences match recipe's dietary tag
                if (recipe.contains("Category: " + category) && client.getDietPreferences().equalsIgnoreCase(getDietTag
                (recipe))) {
                    //get the calories of the current recipe 
                    double recipeCalories = getCalories(recipe);
                    //check if the recipe's calories are less than or equal to the client's calculated calories
                    if (recipeCalories <= client.calculateCalories()) {
                        //when all conditions are met, add recipe o the list of valid recipes
                        validRecipes.add(recipe);
                    }
                }
            } 
            //check if there are valid recipes for the current category
            if (!validRecipes.isEmpty()) {
                //generate a random index within the validRecipes list
                int randomIndex = random.nextInt(validRecipes.size());
                //get the recipe at the randomly chosen index
                String chosenRecipe = validRecipes.get(randomIndex);
                //add the chosen recipe to the mealSetBuilder
                mealSetBuilder.append(chosenRecipe).append("\n");
            }
        } 
        //add the meal set for the current category to the list of suggested meals
        suggestedMeals.add(mealSetBuilder.toString());
        //return the list of suggested meals, which contain the meal sets for all categories
        return suggestedMeals;
    }  
    
    //method to generate the complete meal plan as a string
    private String generateMealPlan(int mealSets) {
        //create a stringBuilder to construct the meal plan text
        StringBuilder sb = new StringBuilder(); 
        //add client's full name to meal plan
        sb.append("Meal Plan for: ").append(client.getFullName()).append("\n");
        //add the number of meal sets per week to the meal plan with line breaks
        sb.append("Meal Sets Per Week: ").append(mealSets).append("\n\n");    
        //create list to hold the sets of suggested meals
        ArrayList <ArrayList<String>> suggestedMealSets = new ArrayList<>(); 
        //loop through each meal set
        for (int mealSet = 1; mealSet <= mealSets; mealSet++) {
            //get the suggested meals for the curreent meal set
            ArrayList<String> suggestedMeals = suggestMeals(client);
            //add the title of the current meal set to the meal plan
            sb.append("Meal Set ").append(mealSet).append(":\n"); 
            //loop through each suggested meal in the meal set
            for (int mealIndex = 0; mealIndex < suggestedMeals.size(); mealIndex++) {
                //add the suggested meal to the meal plan
                sb.append(suggestedMeals.get(mealIndex)).append("\n");
                //check if this isnt the last meal in meal set
                if (mealIndex < suggestedMeals.size() - 1) {
                    //add seperator line 
                    sb.append("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -\n");
                }
            } 
            //check if this isn't the last meal set
            if (mealSet < mealSets) {
                //add seperator line
                sb.append("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -\n");
            }
        } 
        //return the complete meal plan as a formatted string
        return sb.toString();
    } 
    
    //method to generate motivational message based on the number of sets
    public String generateMotivationalMessage(int mealSets) {
        //if number of meal sets is 3 or fewer
        if (mealSets <= 3) {
            //return this message
            return "Great job! You're starting your fitness journey. Remember, consistency is key!";
          //if number of meal sets is between 4 and 5
        } else if (mealSets <= 5) {
            //return this message
            return "You're doing a fantastic job! Keep up the great work and stay commited to your goals!";
         //if number of meal sets is more than 5
        } else {
            //return this message
            return "Wow you're really dedicated to your health and fitness! Hard work will pay off!";
        }
    }
    
    //override the toString method to return the generated meal plan
    @Override 
    //method overrides default toString method to return the generated mealplan as string
    public String toString() {
        //calls the generate meal plan method and returns as string
        return generateMealPlan(mealSets);
    }
}

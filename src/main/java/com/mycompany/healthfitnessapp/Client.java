/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.healthfitnessapp;

import java.util.ArrayList;

/** This is the client class in which all user portfolios are generated and saved in the using File I/O.
 * Date: August 20, 2023
 * @author Akshayan
 */
// Definition of the Client class
public class Client {
    // Private fields to store client information and variables in order to access
    private String fullName;
    private String gender;
    private double heightCm;
    private int weightLbs;
    private int numAge;
    private String outHobby;
    private String medicalConditions;
    private String medicalConditionsType;
    private String dietPreferences;
    private String isAddictions;
    private String isPregnant;
    
    // Constructor to initialize client information
    public Client (String fullName, String gender, double heightCm, int weightLbs, int numAge, String outHobby, String medicalConditions, String medicalConditionsType, String dietPreferences, String isAddictions, String isPregnant) {
        // Initialize the fields with provided values
        this.fullName = fullName;
        this.gender = gender;
        this.heightCm = heightCm;
        this.weightLbs = weightLbs;
        this.numAge = numAge;
        this.outHobby = outHobby;
        this.medicalConditions = medicalConditions;
        this.dietPreferences = dietPreferences;
        this.isAddictions = isAddictions;
        this.isPregnant = isPregnant;
   
    }
    // Getter method for retrieving the full name
    public String getFullName() {
        return fullName;
    }
    // Setter method for setting the full name
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    // Getter method for retrieving the gender
    public String getGender() {
        return gender;
    }
    // Setter method for setting the gender
    public void setGender(String gender) {
        this.gender = gender;
    }
    // Getter method for retrieving the height in centimeters
    public double getHeightCm() {
        return heightCm;
    }
    // Setter method for setting the height in centimeters
    public void setHeightCm(double heightCm) {
        this.heightCm = heightCm;
    }
    // Getter method for retrieving the weight in pounds
    public int getWeightLbs() {
        return weightLbs;
    }
    // Setter method for setting the weight in pounds
    public void setWeightLbs(int weightLbs) {
        this.weightLbs = weightLbs;
    }
    // Getter method for retrieving the age
    public int getNumAge() {
        return numAge;
    }
    // Setter method for setting the age
    public void setNumAge(int numAge) {
        this.numAge = numAge;
    }
    // Getter method for retrieving the outdoor hobby
    public String getOutHobby() {
        return outHobby;
    }
    // Setter method for setting the outdoor hobby
    public void setOutHobby(String outHobby) {
        this.outHobby = outHobby;
    }
    // Getter method for retrieving the presence of medical conditions
    public String isMedicalConditions() {
        return medicalConditions;
    }
    // Setter method for setting the presence of medical conditions
    public void setMedicalConditions(String medicalConditions) {
        this.medicalConditions = medicalConditions;
    }
    // Getter method for retrieving the type of medical conditions
    public String getMedicalConditionsType() {
        return medicalConditionsType;
    }
    // Setter method for setting the type of medical conditions
    public void setMedicalConditionsType(String medicalConditionsType) {
        this.medicalConditionsType = medicalConditionsType;
    }
    // Getter method for retrieving diet preferences
    public String getDietPreferences() {
        return dietPreferences;
    }
    // Setter method for setting diet preferences
    public void setDietPreferences(String dietPreferences) {
        this.dietPreferences = dietPreferences;
    }
    // Getter method for retrieving information about addictions
    public String isIsAddictions() {
        return isAddictions;
    }
    // Setter method for setting information about addictions
    public void setIsAddictions(String isAddictions) {
        this.isAddictions = isAddictions;
    }
    // Getter method for retrieving information about pregnancy
    public String isIsPregnant() {
        return isPregnant;
    }
    // Setter method for setting information about pregnancy
    public void setIsPregnant(String isPregnant) {
        this.isPregnant = isPregnant;
    }
    // Method to calculate BMI (Body Mass Index)
    public double calculateBMI() {
        double heightMeters = (this.heightCm / 100); // Convert height from cm to meters
        double weightKgs = (this.weightLbs/2.205);
        double bmi = (weightKgs / (heightMeters * heightMeters));
        return bmi;
    }
    // Method to calculate daily calorie intake based on gender, height, weight, and age
    public double calculateCalories() {
        // Convert height from centimeters to meters
        double heightMeters = heightCm / 100;
        // Convert weight from pounds to kilograms
        double weightinKg = weightLbs * 0.45359237;
        //Initializes the variable to store calculated calorie
        double calories = 0;
        //Calculate calories using Harris-Benedict equation for BMR and activity level
        if (this.gender.equals("M"))  {
            calories = (9.99 * weightinKg + 6.25 * this.heightCm - 4.92 * this.numAge + 5) *1.375;
        }else if (this.gender.equals("F"))  {
            calories = (9.99 * weightinKg + 6.25 * this.heightCm - 4.92 * this.numAge - 161) *1.375;
        }
        return calories;
    }
    // Method to calculate ideal body weight based on gender and height
    public double idealBodyWeight() {
        // Initialize the variable to store ideal body weight
        double bodyWeight = 0;
        // Calculate ideal body weight using Broca's formula
        if (this.gender.equals("M")) {
            bodyWeight = 50 + (0.91*(this.heightCm - 152.4));
        }else if (this.gender.equals("F"))  {
            bodyWeight = 45.5 + (0.91*(this.heightCm - 152.4));
        }
        return bodyWeight;
    }
    // Method to calculate recommended daily protein intake based on gender, weight, and age
    public double proteinIntake() {
        // Initialize the variable to store recommended protein intake
        double protein = 0;
        // Convert weight from pounds to kilograms
        double weightInKg = this.weightLbs/2.205;
        // Calculate protein intake based on gender, age, and weight
        if (this.gender.equals("M"))  {
            if (this.numAge >=16 && this.numAge <=18) {
                protein = weightInKg*0.93;
            }else if (this.numAge >=19 && this.numAge <=75) {
                protein = weightInKg*0.99;
            }  
        }if (this.gender.equals("F")) {
            if (this.numAge >=16 && this.numAge <=75) {
                protein = weightInKg*0.95;
            }
        }
        return protein;
    }
   
    // Override the default toString() method to provide a custom string representation of the object
    @Override
    public String toString() {
        // Create a formatted string that represents the client's information
        return "\n\nNew Client: " + "Full Name: " + fullName + ", Gender: " + gender + ", Ideal Body Weight : " + idealBodyWeight() + ", Body Mass Index : " + (int)calculateBMI() + ", Total Calories : " + calculateCalories() + ", Required protein intake : " + proteinIntake() +  ", Height in Cm: " + heightCm + ", Weight in lbs: " + weightLbs + ", Age: " + numAge + ", Outdoor Hobby: " + outHobby + ", Medical Condition: " + medicalConditions + ", Medical Conditions Type: " + medicalConditionsType + ", Diet Preferences: " + dietPreferences + ", " + isAddictions + ", " + isPregnant;
    }
   
   
   
   
   
   

   
}

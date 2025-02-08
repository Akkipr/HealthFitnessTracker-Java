package com.mycompany.healthfitnessapp;


import com.mycompany.healthfitnessapp.Client;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/** This is the water and sleep monitor class that ensures the user is getting enough of each entity and offering ample advice.
 * Date: August 21, 2023
 * @author Bavishan
 */

/**
 * Represents health-related data for a client, including water intake, average sleep, and physical exhaustion.
 */
public class HealthData{
    private Client client; // Reference to the associated client
    private int waterIntake; // Daily water intake in ounces
    private int avgSleep; // Average sleep duration in hours
    private String exhaustingDay; // Indicates whether the day was exhausting ("Yes") or not ("No")
    /**
     * Constructs a HealthData object with the provided data.
     *
     * @param client The associated client.
     * @param waterIntake The daily water intake in ounces.
     * @param avgSleep The average sleep duration in hours.
     * @param exhaustingDay Indicates whether the day was exhausting ("Yes") or not ("No").
     */
    public HealthData(Client client, int waterIntake, int avgSleep, String exhaustingDay) {
        this.client = client;
        this.waterIntake = waterIntake;
        this.avgSleep = avgSleep;
        this.exhaustingDay = exhaustingDay;
    }
    // Getters and setters for the health data properties
    /**
     * Retrieves the daily water intake.
     *
     * @return The daily water intake in ounces.
     */
    public int getWaterIntake() {
        return waterIntake;
    }
    /**
     * Retrieves the average sleep duration.
     *
     * @return The average sleep duration in hours.
     */
    public int getAvgSleep() {
        return avgSleep;
    }
    /**
     * Retrieves whether the day was exhausting or not.
     *
     * @return "Yes" if the day was exhausting, "No" otherwise.
     */
    public String getExhaustingDay() { // Change the return type to boolean
        return exhaustingDay;
    }
    /**
     * Sets the daily water intake.
     *
     * @param waterIntake The daily water intake in ounces to set.
     */
    public void setWaterIntake(int waterIntake) {
        this.waterIntake = waterIntake;
    }
    /**
     * Sets the average sleep duration.
     *
     * @param avgSleep The average sleep duration in hours to set.
     */
    public void setAvgSleep(int avgSleep) {
        this.avgSleep = avgSleep;
    }
    /**
     * Sets whether the day was exhausting or not.
     *
     * @param exhaustingDay "Yes" if the day was exhausting, "No" otherwise.
     */
    public void setExhaustingDay(String exhaustingDay) { // Change the parameter type to boolean
        this.exhaustingDay = exhaustingDay;
    }
    /**
     * Calculates the recommended water intake based on the client's gender.
     *
     * @return The recommended water intake in ounces.
     */
    public int calculateRecommendedWaterIntake() {
        int recommendedWaterIntake = 0;
        if (client.getGender().equalsIgnoreCase("M")) {
            recommendedWaterIntake = 125; // Recommended water intake for men in ounces
        } else if (client.getGender().equalsIgnoreCase("F")) {
            recommendedWaterIntake = 91; // Recommended water intake for women in ounces
        }
        return recommendedWaterIntake;
    }
   
   
    /**
    * Calculates the recommended sleep duration based on the client's age and whether the day was exhausting.
    *
    * @return The recommended sleep duration in hours.
    */
    // Method to calculate recommended sleep based on age and exhausting day
    public int calculateRecommendedSleep() {
        int recommendedSleep;

        if (exhaustingDay.equals("Yes")) {
            recommendedSleep = 9;// 8 hours of regular sleep + 1 hour nap
        } else {
            recommendedSleep = 8;// 8 hours of regular sleep
        }

        return recommendedSleep;
    }
 
    /**
    * Adjusts the average sleep duration based on whether the day was exhausting.
    *
    * @return The adjusted sleep duration in hours.
    */
    public int adjustSleepDuration() {
        if (exhaustingDay.equals("Yes")) {
            return avgSleep + 1;// Increase sleep by 1 hour if the day was exhausting
        }
        return avgSleep;// Return the original sleep duration if the day was not exhausting
    }
   
    /**
    * Generates feedback regarding the client's water intake and hydration status,
    * based on the recommended water intake and actual water intake recorded.
    *
    * @return A feedback message indicating hydration status and recommendations.
    */
    public String WaterSleepInput(){
        // Calculate the recommended water intake based on the client's gender
        int recommendedWaterIntake = calculateRecommendedWaterIntake();
            // Calculate the difference between the recommended water intake and the actual water intake
            int waterNeeded = recommendedWaterIntake - getWaterIntake();
           
            int recommendedSleep = calculateRecommendedSleep();
            int sleepNeeded = recommendedSleep - getAvgSleep();
            // Initialize an empty feedback message string
            String feedback = "";
            // Check if more water is needed
            if (waterNeeded > 0) {
                feedback += "You need to drink " + waterNeeded + " more ounces of water to stay hydrated.\n";

            }
            // Check if excess water is consumed
            else if (waterNeeded<0){
                feedback += "You are drinking an excess amount of water, an excess of water can cause sodium overload!\n";
            }
            // Provide positive feedback if water intake is optimal
            else{
                feedback += "Great! You are drinking a perfect amount of water, keep this up!\n";
            }
            // Check if additional sleep is needed for better health
            if (sleepNeeded > 0) {
                feedback += "You need to get " + sleepNeeded + " more hours of sleep for better health.\n";
            // Check if sleep duration meets recommendations or exceeds it
            } else if (sleepNeeded <= 0) {
                // Check if the day was exhausting
                if (exhaustingDay.equals("Yes")) {
                    // Check if sleep duration is sufficient considering an exhausting day
                    if (avgSleep >= 9) {
                        feedback += "You're getting enough sleep considering the exhausting day. Good job!\n";
                    }
                    // Provide feedback to encourage more sleep due to the exhausting day
                    else {
                        feedback += "You're getting enough sleep, but try to get more if possible due to the exhausting day.\n";
                    }
                // Check if sleep duration is perfect for a non-exhausting day
                } else {
                    if (avgSleep == 8) {
                        feedback += "You're getting the perfect amount of sleep. Good job!\n";
                    }
                    // Provide feedback indicating that sleep duration is sufficient
                    else {
                        feedback += "Please be mindful of getting 8 hours of sleep.\n";
                    }
                }
            }

            // Check if average sleep duration exceeds 9 hours
            if (avgSleep > 9) {
                feedback += "Sleeping too much regularly could lead to a build up of fat and other health risks!\n";
            }
            // Check if the day was exhausting
            if (exhaustingDay.equals("Yes")) {
                //Suggest taking a nap for around an hour due to a physically exhausting day
                feedback += "Consider to try to get a nap in for around an hour (9 hours in total of sleep).\n";
               
            }
            // Return the aggregated feedback message
            return feedback;
    }
   
}
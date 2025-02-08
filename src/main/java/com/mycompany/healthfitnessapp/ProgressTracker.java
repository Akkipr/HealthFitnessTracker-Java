/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.healthfitnessapp;

/** This is the class in which the progress of each individual can be inputted, and will be compared to previous stats.
 * Date: August 21, 2023
 * @author Akshayan
 */

/**
 * This class represents a progress tracker that monitors changes and improvements in a fitness plan.
 */
public class ProgressTracker {
    // Fields to store various progress-related data
    private int bmi;
    private int startingWeight;
    private FitnessPlan fitness;
    private int currentWeight;
    private int initialSquatCount;
    private int initialMaxPlank;
    private int initialPushupCount;
    private int initialTreadmill;
    private int currentSquatCount;
    private int currentMaxPlank;
    private int currentPushupCount;
    private int currentTreadmill;
   
    /**
    * This constructor initializes a ProgressTracker object with the provided values for tracking fitness progress.
    *
    * @param startingWeight The initial weight of the individual.
    * @param bmi The Body Mass Index (BMI) of the individual.
    * @param initialSquatCount The initial count of squats in the fitness plan.
    * @param initialMaxPlank The initial maximum plank duration in the fitness plan.
    * @param initialPushupCount The initial count of pushups in the fitness plan.
    * @param initialTreadmill The initial treadmill duration in the fitness plan.
    * @param currentWeight The current weight of the individual.
    * @param currentSquatCount The current count of squats performed.
    * @param currentMaxPlank The current maximum plank duration achieved.
    * @param currentPushupCount The current count of pushups performed.
    * @param currentTreadmill The current treadmill duration achieved.
    */
    public ProgressTracker(int startingWeight, int bmi, int initialSquatCount, int initialMaxPlank, int initialPushupCount, int initialTreadmill, int currentWeight, int currentSquatCount, int currentMaxPlank, int currentPushupCount, int currentTreadmill ) {
        // Initialize the fields with provided values
        this.bmi = bmi;
        this.startingWeight = startingWeight;
        this.initialSquatCount = initialSquatCount;
        this.initialMaxPlank = initialMaxPlank;
        this.initialPushupCount = initialPushupCount;
        this.initialTreadmill = initialTreadmill;
        this.currentWeight = currentWeight;
        this.currentSquatCount = currentSquatCount;
        this.currentMaxPlank = currentMaxPlank;
        this.currentPushupCount = currentPushupCount;
        this.currentTreadmill = currentTreadmill;
               
    }

   
    /**
    * Retrieves the current weight of the individual.
    *
    * @return The current weight of the individual.
    */
    public int getCurrentWeight() {
       return currentWeight;
    }

   /**
    * Sets the current weight of the individual.
    *
    * @param currentWeight The new current weight value to be set.
    */
    public void setCurrentWeight(int currentWeight) {
       this.currentWeight = currentWeight;
    }

    /**
    * Retrieves the current count of squats performed.
    *
    * @return The current count of squats performed.
    */
    public int getCurrentSquatCount() {
       return currentSquatCount;
    }

    /**
    * Sets the current count of squats performed.
    *
    * @param currentSquatCount The new current squat count value to be set.
    */
    public void setCurrentSquatCount(int currentSquatCount) {
        this.currentSquatCount = currentSquatCount;
    }

    /**
    * Retrieves the current maximum plank duration achieved.
    *
    * @return The current maximum plank duration achieved.
    */
    public int getCurrentMaxPlank() {
        return currentMaxPlank;
    }

    /**
    * Sets the current maximum plank duration achieved.
    *
    * @param currentMaxPlank The new current maximum plank duration value to be set.
    */
    public void setCurrentMaxPlank(int currentMaxPlank) {
        this.currentMaxPlank = currentMaxPlank;
    }

    /**
     * Retrieves the current count of pushups performed.
    *
    * @return The current count of pushups performed.
    */
    public int getCurrentPushupCount() {
        return currentPushupCount;
    }

    /**
    * Sets the current count of pushups performed.
    *
    * @param currentPushupCount The new current pushup count value to be set.
    */
    public void setCurrentPushupCount(int currentPushupCount) {
        this.currentPushupCount = currentPushupCount;
    }

    /**
    * Retrieves the current treadmill duration achieved.
    *
    * @return The current treadmill duration achieved.
    */
    public int getCurrentTreadmill() {
        return currentTreadmill;
    }

    /**
    * Sets the current treadmill duration achieved.
    *
    * @param currentTreadmill The new current treadmill duration value to be set.
    */
    public void setCurrentTreadmill(int currentTreadmill) {
        this.currentTreadmill = currentTreadmill;
    }
    /**
    * Calculates and provides feedback on weight difference and progress.
    *
    * @return A message indicating weight change and progress.
    */
    public String weightDifference() {
        String output = "";
        // Calculate the difference between starting weight and current weight
        double weightDifference = this.startingWeight - this.currentWeight;
        // Check conditions based on weight difference and BMI
        if (weightDifference > 0 && this.bmi > 25) {
            output += "Congratulations, you have successfully lost " + weightDifference + " lbs.";
        }else if (weightDifference < 0 && this.bmi < 18.5) {
            output += "Congratulations, you have successfully gained " + Math.abs(weightDifference) + " lbs.";
        }else if ((weightDifference > -10 && weightDifference < 10) && (this.bmi>18.5 && this.bmi<25)) {
            output += "Congratulations, the difference between your starting and current weight is " + Math.abs(weightDifference) + " lbs.";
        }else {
            output += "Oh no, it seems the weight has not gone towards your target. You have to be more conscious of your food and workout in order to see positive changes in weight";
        }
        // Add the results of otherCalculations() to the output
        output+= otherCalculations();
        return output;
    }
    /**
    * Calculates and provides feedback on improvements in various exercises and workouts.
    *
    * @return A message indicating improvements in squat count, pushup count, plank duration, and treadmill endurance.
    */
    public String otherCalculations() {
        String output = "";
        // Calculate differences in various exercises and workouts
        int squatDifference = this.currentSquatCount - this.initialSquatCount;
        int pushupDifference = this.currentPushupCount - this.initialPushupCount;
        int plankDifference = this.currentMaxPlank - this.initialMaxPlank;
        int treadmillDifference = this.currentTreadmill - this.initialTreadmill;
       
        // Check and provide feedback for improvements in different exercises
        if (squatDifference > 0) {
            output += "\nIt seems your squat count has also increased by " + squatDifference + ". Congrats!";
        }
        if (pushupDifference > 0) {
            output += "\nIt seems your pushup count has also increased by " + pushupDifference + ". Congrats!";
        }
        if (plankDifference > 0) {
            output += "\nIt seems your plank limit has also increased by " + plankDifference + ". Congrats!";
        }
        if (treadmillDifference > 0) {
            output += "\nIt seems your treadmill endurance has also increased by " + treadmillDifference + ". Congrats!";
        }if (squatDifference <= 0) {
            output += "\n Oh no. It seems your squat count has not increased. You should do more weighted squats and leg extensions to improve.";
        }if (pushupDifference <= 0) {
            output += "\n Oh no. It seems your pushup count has not increased. You should do more half-pushups that are weighted to improve.";
        }if (plankDifference <= 0) {
            output += "\n Oh no. It seems your plank has not increased. You should do more half planks for burst intervals to improve.";
        }if (treadmillDifference <= 0) {
            output += "\n Oh no. It seems your treadmill duration has not increased. You should do more longer walks or jump rope to improve.";
        }
        return output;
       
    }
   
   
    /**
    * Overrides the default toString() method to provide a formatted string representation of the ProgressTracker object.
    *
    * @return A formatted string containing information about the progress in weight, BMI, exercises, and workouts.
    */
    @Override
    public String toString() {
        return "ProgressTracker{" + " Previous Weight: " + startingWeight + ", Current Weight: " + currentWeight + ", Current BMI: " + this.bmi + " lbs, Current Squat Count: " + currentSquatCount + ", Current Max Plank: " + currentMaxPlank + " seconds, Current Pushup Count: " + currentPushupCount + ", Current Treadmill: " + currentTreadmill + " seconds" + '}';
    }
   
   
   
   
}
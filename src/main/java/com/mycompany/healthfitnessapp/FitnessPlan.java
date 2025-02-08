/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.healthfitnessapp;
// Import statements for necessary Java classes and packages


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * The FitnessPlan class represents a fitness plan for a client, including various workout parameters.
 * Date: August 20, 2023.
 * Author: Akshayan Prabaharan
 */
public class FitnessPlan {
    // ArrayList to store different workout intensities and their corresponding exercises
    private ArrayList<ArrayList<String>> workoutsByIntensity = new ArrayList<>();
    // different variables to initialize in order to use for the class
    private Client client;
    private int targetWeight;
    private int squatCount;
    private int maxPlank;
    private int pushupCount;
    private int treadmill;
    private int counter;
   
   

    //Client- The associated Client object for this fitness plan.
    //targetWeight- The target weight set by the client for their fitness goals.
    //quatCount-The number of squats recommended in the fitness plan.
    //maxPlank-The maximum duration of a plank exercise in seconds.
    //pushupCount-The number of pushups recommended in the fitness plan.
    //treadmill-The duration of treadmill exercise in minutes.
    public FitnessPlan(Client client, int targetWeight, int squatCount, int maxPlank, int pushupCount, int treadmill ) {
        // Initialize the 'client' field with the provided Client object
        this.client = client;
        // Initialize various fitness plan parameters
        this.targetWeight = targetWeight; // Initialize target weight
        this.squatCount = squatCount; // Initialize number of squats
        this.maxPlank = maxPlank; // Initialize maximum plank duration
        this.pushupCount = pushupCount; // Initialize number of pushups
        this.treadmill = treadmill; // Initialize treadmill duration
               
    }
   
    /**
     * Getter method to retrieve the workouts organized by intensity levels.
     *
     * @return An ArrayList containing ArrayLists of workout details organized by intensity.
     */
    public ArrayList<ArrayList<String>> getWorkoutsByIntensity() {
        return workoutsByIntensity;
    }

    /**
     * Setter method to set the workouts organized by intensity levels.
     *
     * @param workoutsByIntensity The ArrayList containing ArrayLists of workout details organized by intensity.
     */
    public void setWorkoutsByIntensity(ArrayList<ArrayList<String>> workoutsByIntensity) {
        this.workoutsByIntensity = workoutsByIntensity;
    }

    /**
     * Getter method to retrieve the target weight specified in the fitness plan.
     *
     * @return The target weight specified in the fitness plan.
     */
    public double getTargetWeight() {
        return targetWeight;
    }

   
    //Setter method to set the target weight specified in the fitness plan.
   
    //targetWeight The target weight to be set in the fitness plan.
   
    public void setTargetWeight(int targetWeight) {
        this.targetWeight = targetWeight;
    }

   
    //Getter method to retrieve the number of squats recommended in the fitness plan.
    //The number of squats recommended in the fitness plan.  
    public int getSquatCount() {
        return squatCount;
    }

   
    //Setter method to set the number of squats recommended in the fitness plan.
    //squatCount The number of squats to be set in the fitness plan.
    public void setSquatCount(int squatCount) {
        this.squatCount = squatCount;
    }

   
    //Getter method to retrieve the maximum duration of a plank exercise in seconds.
    //The maximum duration of a plank exercise in seconds.
    public int getMaxPlank() {
        return maxPlank;
    }

    /**
     * Setter method to set the maximum duration of a plank exercise in seconds.
     *
     * @param maxPlank The maximum duration of a plank exercise to be set.
     */
    public void setMaxPlank(int maxPlank) {
        this.maxPlank = maxPlank;
    }

    /**
     * Getter method to retrieve the number of pushups recommended in the fitness plan.
     *
     * @return The number of pushups recommended in the fitness plan.
     */
    public int getPushupCount() {
        return pushupCount;
    }

    /**
     * Setter method to set the number of pushups recommended in the fitness plan.
     *
     * @param pushupCount The number of pushups to be set in the fitness plan.
     */
    public void setPushupCount(int pushupCount) {
        this.pushupCount = pushupCount;
    }

    /**
     * Getter method to retrieve the duration of treadmill exercise in minutes.
     *
     * @return The duration of treadmill exercise in minutes.
     */
    public int getTreadmill() {
        return treadmill;
    }

    /**
     * Setter method to set the duration of treadmill exercise in minutes.
     *
     * @param treadmill The duration of treadmill exercise to be set.
     */
    public void setTreadmill(int treadmill) {
        this.treadmill = treadmill;
    }

    /**
     * Getter method to retrieve the counter value.
     *
     * @return The counter value.
     */
    public int getCounter() {
        return counter;
    }

    /**
     * Setter method to set the counter value.
     *
     * @param counter The counter value to be set.
     */
    public void setCounter(int counter) {
        this.counter = counter;
    }


   
    /**
    * Calculates the difference between the target weight and the client's current weight,
    * and provides guidance on whether to lose or gain weight to achieve the goal.
    *
    * @return A message indicating the weight goal (loss/gain) needed to achieve the target weight.
    */
    public String newWeight() {
        // Calculate the difference between the target weight and the client's current weight
        double weightGoal = this.targetWeight - client.getWeightLbs();
        String output = "";
        // Check if weight goal is negative (loss) or positive (gain)
        if (weightGoal < 0 && client.calculateBMI() > 25) { //include bmi
            output += "You have to lose " + Math.abs(weightGoal) + "lbs in order to achieve your goal.";
        }else if (weightGoal > 0 && client.calculateBMI() < 18.5) {
            output += "You have to gain " + weightGoal + "lbs in order to achieve your goal.";
        }else if ((client.calculateBMI() >= 18.5 && client.calculateBMI() <= 25) && (weightGoal >=-10 && weightGoal <= 10)) {
            output += "You can lose or gain " + Math.abs(weightGoal) + "lbs to stay healthy";
        }
        return output;
    }
   
    /**
    * Generates new fitness goals for the coming week by incrementing exercise values.
    *
    * @return A message with the new goals for squats, pushups, max plank, and treadmill endurance.
    */
    public String newGoals() {
        // Calculate the next targets for various exercises
        int nextSquat = this.squatCount + 5;
        int nextPushup = this.pushupCount + 5;
        int nextMaxPlank = this.maxPlank + 10;
        int nextTreadmill = this.treadmill + 20;

       return "Within the coming week, your goal is to increase your squats to: " +
              nextSquat + ", your pushups to " + nextPushup + ", your max plank to " +
              nextMaxPlank + " seconds, and your treadmill 7.5mph endurance run to " +
              nextTreadmill + " seconds.";
   }

   
   
    /**
    * Reads and organizes workout plans from a file into intensity-based groups.
    * Each workout is stored in an ArrayList and organized by intensity in the 'workoutsByIntensity' list.
    */
    public void workoutPlan() {
        try (BufferedReader reader = new BufferedReader(new FileReader("Workout Plan.txt"))) {
            String line;
            ArrayList<String> currentWorkout = new ArrayList<>();
            // Iterate through each line in the file
            while ((line = reader.readLine()) != null) {
                // Check if the line indicates a new intensity level
                if (line.startsWith("Intensity:")) {
                    // If there's a current workout, add it to the list and start a new ArrayList
                    if (!currentWorkout.isEmpty()) {
                        workoutsByIntensity.add(currentWorkout);
                    }
                    currentWorkout = new ArrayList<>();
                }

                // Add the current line to the current workout
                currentWorkout.add(line);
            }
            // Add the last workout (if any) to the list
            if (!currentWorkout.isEmpty()) {
                workoutsByIntensity.add(currentWorkout);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Displays the fitness plan and recommendations based on the client's BMI, age, and goals.
    public String display() {
        // Organize workout plans and sort them
        workoutPlan();
        sortMethod();
        // Initialize the output string
        String output = "";
        // Evaluate client's BMI and age to provide suitable recommendations
        if ((client.getNumAge() > 50) || client.isMedicalConditions().equals("Yes") || client.isIsPregnant().equals("Yes")) {
            output += "Age, conditions or pregnancy is a critical factor when it comes to gaining or losing weight, and we want to ensure we do not overwork the joints ";
            // Provide recommendations for clients with age over 50 or medical conditions
            int indexWorkout = 0;
            output += "\nSunday: \n" + String.valueOf(workoutsByIntensity.get(indexWorkout));
            output += "\nMonday: \n" + String.valueOf(workoutsByIntensity.get(indexWorkout+1));
            output += "\nTuesday: \n" + String.valueOf(workoutsByIntensity.get(indexWorkout+2));
            output += "\nWednesday: \n" + String.valueOf(workoutsByIntensity.get(indexWorkout+3));
            output += "\nThursday: \n" + String.valueOf(workoutsByIntensity.get(indexWorkout+4));
            output += "\nFriday: \n" + String.valueOf(workoutsByIntensity.get(indexWorkout+5));
            output += "\nSaturday: \n Rest day for the recovery of the muscles. Try your hobby! " + client.getOutHobby();
        }else if ((client.calculateBMI() >= 18.5 && client.calculateBMI() <= 25)) {
            // Provide recommendations for clients within the ideal weight range
            output += "Since you are in the ideal weight range, the following workouts will simply keep your weight and muscle mass while also being active";
            int indexWorkout = (0 + workoutsByIntensity.size()-1) / 2;
            output += "\nSunday: \n" + String.valueOf(workoutsByIntensity.get(indexWorkout));
            output += "\nMonday: \n" + String.valueOf(workoutsByIntensity.get(indexWorkout-1));
            output += "\nTuesday: \n" + String.valueOf(workoutsByIntensity.get(indexWorkout+1));
            output += "\nWednesday: \n" + String.valueOf(workoutsByIntensity.get(indexWorkout-2));
            output += "\nThursday: \n" + String.valueOf(workoutsByIntensity.get(indexWorkout+2));
            output += "\nFriday: \n" + String.valueOf(workoutsByIntensity.get(indexWorkout-3));
            output += "\nSaturday: \n Rest day for the recovery of the muscles. Try your hobby! " + client.getOutHobby();
        }else if (client.calculateBMI() > 25 && (client.getNumAge() >15 && client.getNumAge() <=50)) {
            output += "Since you are overweight, the following workouts will be more intensive and cardio related to lose weight";
            // Provide recommendations for overweight clients
            int indexWorkout = workoutsByIntensity.size()-1;
            output += "\nSunday: \n" + String.valueOf(workoutsByIntensity.get(indexWorkout));
            output += "\nMonday: \n" + String.valueOf(workoutsByIntensity.get(indexWorkout-1));
            output += "\nTuesday: \n" + String.valueOf(workoutsByIntensity.get(indexWorkout-2));
            output += "\nWednesday: \n" + String.valueOf(workoutsByIntensity.get(indexWorkout-3));
            output += "\nThursday: \n" + String.valueOf(workoutsByIntensity.get(indexWorkout-4));
            output += "\nFriday: \n" + String.valueOf(workoutsByIntensity.get(indexWorkout-5));
            output += "\nSaturday: \n Rest day for the recovery of the muscles. Try your hobby! " + client.getOutHobby();
        }else if (client.calculateBMI() < 18.5 && (client.getNumAge() >15 && client.getNumAge() <=50)) {
            // Provide recommendations for underweight clients
            output += "Since you are underweight, the following workouts will be more intensive and muscle-building related to gain weight";
            int indexWorkout = (0 + workoutsByIntensity.size()-1) / 2;
            output += "\nSunday: \n" + String.valueOf(workoutsByIntensity.get(indexWorkout));
            output += "\nMonday: \n" + String.valueOf(workoutsByIntensity.get(indexWorkout-4));
            output += "\nTuesday: \n" + String.valueOf(workoutsByIntensity.get(indexWorkout+4));
            output += "\nWednesday: \n" + String.valueOf(workoutsByIntensity.get(indexWorkout-5));
            output += "\nThursday: \n" + String.valueOf(workoutsByIntensity.get(indexWorkout+5));
            output += "\nFriday: \n" + String.valueOf(workoutsByIntensity.get(indexWorkout+6));
        }
        // Append new goals and weight information to the output
        output += "\n" + newGoals();
        output += "\n" + newWeight();
        // Return the final output
        return output;
    }
    /**
 * Gets the intensity level of a workout based on its description lines.
 *
 * @param workoutLines The lines that make up a workout's description.
 * @return The intensity level of the workout, or 0 if not found.
 */
    public int getIntensity(ArrayList<String> workoutLines) {
        // Iterate through each line in the workout description
        for (String line : workoutLines) {
            // Check if the line starts with "Intensity:"
            if (line.startsWith("Intensity:")) {
                // Extract the intensity value from the line and remove extra whitespace
                String intensityString = line.split(": ")[1].trim(); // Remove whitespace
                // Parse and return the intensity value as an integer
                return Integer.parseInt(intensityString);
            }
        }
        // If no intensity line is found, return 0 as default
        return 0;
    }
   
   
    /**
    * Sorts the list of workouts in 'workoutsByIntensity' based on their intensity levels.
    * The selection sort algorithm is used to rearrange workouts from low to high intensity.
    */
    public void sortMethod() {
        int n = workoutsByIntensity.size();// Number of workouts in the list
        // Iterate through each workout in the list
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;// Assume the current workout has the minimum intensity
            // Find the index of the minimum intensity workout among the remaining workouts
            for (int j = i + 1; j < n; j++) {
                // Get the intensity levels of the current and minimum intensity workouts
                int intensity1 = getIntensity(workoutsByIntensity.get(j));// Intensity of workout j
                int intensity2 = getIntensity(workoutsByIntensity.get(minIndex));// Intensity of current minimum workout
                // Compare intensity levels and update minIndex if a lower intensity is found
                if (intensity1 < intensity2) {
                    minIndex = j;
                }
            }
            // Swap the current workout with the minimum intensity workout
            ArrayList<String> temp = workoutsByIntensity.get(minIndex);// Store the minimum intensity workout temporarily
            workoutsByIntensity.set(minIndex, workoutsByIntensity.get(i));// Assign the current workout to the minimum intensity's position
            workoutsByIntensity.set(i, temp);// Place the minimum intensity workout in the current workout's original position
        }

    }
   
   
   
   
   
        /**
     * Overrides the default 'toString()' method to provide a customized string representation of the FitnessPlan object.
     *
     * @return A formatted string containing various fitness plan details, including target weight, current weight,
     *         current BMI, squat count, max plank duration, pushup count, and treadmill duration.
     */
    @Override
    public String toString() {
        return "FitnessPlan{" + " Target Weight: " + targetWeight + " lbs" + ", Current Weight: " + client.getWeightLbs() + ", Current BMI: " + (int) client.calculateBMI() +  ", Squat Count: " + squatCount + ", Max Plank: " + maxPlank + " seconds, Pushup Count: " + pushupCount + ", Treadmill: " + treadmill + '}';
       
    }
 
   
}
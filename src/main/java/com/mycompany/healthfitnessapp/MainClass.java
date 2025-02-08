/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.healthfitnessapp;

// Import necessary packages
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/** This is the main class that harnesses the interface, and which all objects are called and inputs are prompted.
 *  Date: August 21, 2023
 * @author Manvi, Akshayan, Bavishan
 */

// Define the MainClass which extends JFrame
public class MainClass extends javax.swing.JFrame {
    // Declare class-level variables
    public Client client;  // Instance of the Client class
    public FitnessPlan fitness;  // Instance of the FitnessPlan class
    public ArrayList<String> clientArray = new ArrayList<>();  // ArrayList to store client data
    private static int counter = 0;  // Counter to track instances of MainClass
    private javax.swing.JTextArea txtFeedback;  // JTextArea for displaying feedback
    // Constructor for MainClass
    public MainClass() {
        // Call startScreen() method to set up initial screen
        startScreen();
        // reading the client txt file each time the program is run, and adding it to an array
        try {
            // Try block for reading client data from "client.txt" file

            // Create a BufferedReader to read from the "client.txt" file
            BufferedReader reader = new BufferedReader(new FileReader("client.txt"));
            String line = "";
            // Read lines from the file until there are no more lines
            while ((line = reader.readLine()) != null) {
                // Add the read line to the clientArray
                clientArray.add(line);
            }
            // Close the reader to release resources
            reader.close();
        }catch (IOException ex) {
            // Catch block for handling IOException

            // If an IOException occurs (e.g., file read error), handle it
            ex.printStackTrace();
        }
        
        
        // Initialize GUI components
        initComponents();
    }
    // Method to set up the initial screen
    private void startScreen() {
        // Display a message dialog using JOptionPane to provide a welcome message
        // Parent component (this refers to the current JFrame)
        JOptionPane.showMessageDialog(this, "<Html><font face = 'Lucida Handwriting' color = 'Black' size = '5'> Hello, Welcome to your Health App!\n" + "<Html><font face = 'Lucida Handwriting' color = 'Black' size = '5'>\nThis app was created by \n\nAkshayan Prabaharan \nBavishan Mathan \nManvi Sharma \n\nWhat you are about to indulge in will change your life!");
       
    }
    // Method to read input data from a file into the provided ArrayList
    public void getInputs( ArrayList<String> clientArray) {
        printScreen.setText(null);
        String output = "";
        // Uses a try-catch block to handle potential exceptions
        try {
            
            // Get the text entered in the txtFullName field and store it in the fullName variable
            String fullName = txtFullName.getText();
            
            //ensuring that the output is not empty.
            if (fullName.isEmpty() == true) {
                printScreen.setText("Please enter a valid full name as the entry cannot be blank.");
                return;
            }
            
            // using a variation of linear search in order to find any previous editions of the same name.
            for (int i = 0; i < clientArray.size(); i++) {
                if (clientArray.get(i).contains(fullName)) {
                    printScreen.setText("Please enter a valid full name that isn't already on the list.");
                    return;
                }
            }
            
            try {
                // Try to parse the fullName as a double value
                double parseTest = Double.parseDouble(fullName);
                // Check if parseTest - parseTest is equal to 0
                // This condition checks if the input is a numeric value with no fractional part
                if (parseTest - parseTest == 0) {
                    // If the condition is met, set the text of jTextArea2 with an error message
                    printScreen.setText("Please enter a valid full name and not a numerical value.");
                    return;
                }   
            }catch (NumberFormatException nfe) {
                // Catch block for handling NumberFormatException
   
                // If the fullName cannot be parsed as a double (i.e., it's not a numeric value),
                // This means the user has entered the correct type.
            }
            // Get the text entered in the txtGender field and store it in the gender variable
            String gender = txtGender.getText();
            
            //ensuring that the output is not empty.
            if (gender.isEmpty() == true) {
                printScreen.setText("Please enter a valid gender, either 'M' or 'F'.");
                return;
            }
            
            // Check if the entered gender is either "M" (male) or "F" (female)
            if (gender.equals("M") || gender.equals("F")) {
                // If the entered gender is valid, skip this conditional and proceed
            }else {
                // If the entered gender is not valid (neither "M" nor "F"),
                // set the text of jTextArea2 with an error message
                printScreen.setText("Please enter a valid gender, either 'M' or 'F'.");
                return;
            }
               
           
            // Get the text entered in the txtHeightCm field and store it in the stringHeightCm variable
            String stringHeightCm = txtHeightCm.getText();
            // Convert the stringHeightCm to a double value
            double heightCm = Double.parseDouble(stringHeightCm);
            // Get the text entered in the txtWeightLbs field and store it in the stringWeightLbs variable
            String stringWeightLbs = txtWeightLbs.getText();
            // Convert the stringWeightLbs to an integer value
            int weightLbs = Integer.parseInt(stringWeightLbs);
            // Get the text entered in the txtAgeNum field and store it in the stringAge variable
            String stringAge = txtAgeNum.getText();
            // Convert the stringAge to an integer value
            int numAge = Integer.parseInt(stringAge);
            // Check if any of the entered values (heightCm, weightLbs, numAge) are less than 0
            if (heightCm < 0 || heightCm > 240 || weightLbs < 40 || weightLbs > 900 || numAge < 0) {
                // If any of the values are negative, set the text of jTextArea2 with an error message
                printScreen.setText("Please enter a number that is reasonable in real life. ");
                // Exit the method to prevent further processing
                return;
            }
            if (numAge>75 || numAge <= 15) {
                printScreen.setText("Due to your age, it is not safe to gain or lose weight with \nour vigourous workouts and meal plans. Goodbye.");
                // Exit the method to prevent further processing
                return;
            }
            
            // initiailzing the string to get the hobby text.
            String outHobby = txtHobby.getText();
            
            //ensuring that the output is not empty.
            if (outHobby.isEmpty() == true) {
                printScreen.setText("Please do not leave the entry blank and enter a valid hobby .");
                return;
            } 
            
            try {
                double parseTest = Double.parseDouble(outHobby);
                // parse testing the hobby in order to ensure a valid integer was entered.
                if (parseTest - parseTest == 0) {
                    printScreen.setText("Please enter a valid hobby and not a numerical value.");
                    return;
                }
            }catch (NumberFormatException nfe) {
               // this is skipped if there is a parsing error as a string was entered
            }
           
            // making the variables for the inputs that can vary.
            String medicalConditions = "";
            // medical conditions type is set to N/A by default.
            String medicalConditionsType = "N/A";
            String isAddictions = "";
            String isPregnant = "";

           
            // using conditionals in order to set the variables above for medical condition.
            if (buttonMedYes.isSelected() == true) {
                medicalConditions += "Yes";
                medicalConditionsType = null;
                medicalConditionsType = txtMedicalCondition.getText();
                if (medicalConditionsType.isEmpty() == true) {
                    printScreen.setText("Please indicate a medical condition as you selected Yes.");
                    return;
                }
                try {
                    double parseTest = Double.parseDouble(medicalConditionsType);
                    if (parseTest - parseTest == 0) {
                        printScreen.setText("Please enter a string value for medical condition. ");
                        return;
                    }
                }catch (NumberFormatException nfe) {
                    // skips
                }
                output+="\nPlease be careful of your medical condition when working out. \nLight exercises will be given.";
                
            }else if (buttonNoMed.isSelected() == true) {
                // string is changed to no.
                medicalConditions += "No";
            } else {
                // if a button was not entered this conditional is clicked.
                printScreen.setText("Please click the button to indicate whether or not you have a medical condition.");
                return;
            }


             // conditionals to check whether or not the user has an addiction that may prohibit weight.
             if (buttonAddictionYes.isSelected() == true) {
                 isAddictions = "Addictions: Yes";
                 output += "\nYou must be able to control your addiction throughout the health transformation to ensure growth.";
             }else if (buttonAddictionNo.isSelected() == true) {
                 isAddictions = "Addictions: No";
             }else {
                // if a button was not entered this conditional is clicked.
                printScreen.setText("Please click either of the buttons to indicate whether or not you have an addiction.");
                return;
             }
             
            // conditionals to check to see if the user is pregnant or not.
            if (buttonPregYes.isSelected() == true) {
                if (gender.equals("M")) {
                    printScreen.setText("Men cannot be pregnant!!");
                    return;
                }
                output+= "\nIt is not recommended that you workout during a pregnancy, \nbut the program will give you very light exercises for mobility purposes.";
                isPregnant = "Pregnant: Yes";
            }else if (buttonPregNo.isSelected() == true) {
                isPregnant = "Pregnant: No";
            }else {
                // if a button was not entered this conditional is clicked.
                printScreen.setText("Please click either of the buttons indicate whether or not you have are pregnant.");
                return;
            }

            // this is set to none if there are no changes made.
            String dietPreferences = dietComboBox.getSelectedItem().toString();

            // creating a client object with the parameters specified by the user.
            this.client = new Client(fullName, gender, heightCm, weightLbs, numAge, outHobby, medicalConditions, medicalConditionsType, dietPreferences, isAddictions, isPregnant);
            
            // calling all of the setters for the method in order to access them from different classes and for good practice.
            client.setFullName(fullName);
            client.setGender(gender);
            client.setHeightCm(heightCm);
            client.setWeightLbs(weightLbs);
            client.setNumAge(numAge);
            client.setOutHobby(outHobby);
            client.setMedicalConditions(medicalConditions);
            client.setMedicalConditionsType(medicalConditionsType);
            client.setDietPreferences(dietPreferences);
            client.setIsAddictions(isAddictions);
            client.setIsPregnant(isPregnant);
            
            clientArray.add(client.toString());

            try {
                // Try block for the main code logic
                // Create a BufferedWriter to write to the "client.txt" file
                BufferedWriter writer = new BufferedWriter(new FileWriter("client.txt"));
                // Loop through each element (ok) in the clientArray
                for (String ok : clientArray) {
                    // Write the current element (ok) to the file  
                    writer.write(ok);
                    // Write a newline character to separate each element
                    writer.write("\n");
                }
                // Close the writer to save changes and release resources
                writer.close();
            } catch (IOException ex) {
                // Catch block for handling IOException
                // If an IOException occurs (e.g., file write error), handle it
                ex.printStackTrace();// Print the stack trace to the console for debugging
            }
        // Catch block for handling NumberFormatException
        }catch (NumberFormatException nfe) {
            // If a NumberFormatException occurs, set the text of jTextArea2 with an error message
            printScreen.setText("Please enter a valid entry for the required fields.");
            return;
        }
        buttonCreateClient.setEnabled(false);
        output+="\nClient Created! Check File client.txt";
        printScreen1.setText(output);

    }
    // Method to retrieve the 'client' object
    public Client getClient() {
        // Return the 'client' object
        return client;
    }
    // Method to track water intake and provide feedback based on health data
    private void waterTracker(Client client) {
        try {
            // conditional to ensure the user created a portfolio
            if (this.client == null) {
                //display error panel message if client information not found
                JOptionPane.showMessageDialog(this, "Client information not available. ");
                return;
            }
            
            // Get the water intake value from the txtWaterIntake field and convert it to an integer
            int waterIntake = Integer.parseInt(txtWaterIntake.getText());
            // Get the average sleep value from the txtAvgSleep field and convert it to an integer
            String stringAvgSleep = txtAvgSleep.getText();
            int avgSleep = Integer.parseInt(stringAvgSleep);
            // Get the input value for physically exhausting day from the txtExhaustingDay field
            String exhaustingDay = txtExhaustingDay.getText();
            // Error-proofing for exhaustingDay input
            if (!exhaustingDay.equalsIgnoreCase("Yes") && !exhaustingDay.equalsIgnoreCase("No")) {
                // If input is not "Yes" or "No", set the feedbackBox text and exit the method
                txtWaterFeedback.setText("Please enter 'Yes' or 'No' for the physically exhausting day question.");
                return; // Exit the method if there's an error
            }
            // Store the exhaustingDay value in a variable for use
            String exhaustingDayValue = txtExhaustingDay.getText();

            // Create a new HealthData object with the provided data
            HealthData healthData = new HealthData(client, waterIntake, avgSleep, exhaustingDayValue);

            // Get feedback on water intake and sleep using the WaterSleepInput method of the HealthData object
            txtWaterFeedback.setText(healthData.WaterSleepInput());

        }catch (NumberFormatException nfe){
            txtWaterFeedback.setText("Please enter a valid number.");
            return;
        } 
        buttonWaterSleep.setEnabled(false);
        congratsMessage.setText("Congrats! You have finished the application \nprocess. Exit program and click the \nProgress Tracker button at the start \nto update file.");
         
         
    }
    // Method to create a fitness plan based on user inputs and update client data
    private void fitnessPlan( ArrayList<String> clientArray, Client client) {
        try {
            // conditional to ensure the user created a portfolio
            if (this.client == null) {
                //display error panel message if client information not found
                JOptionPane.showMessageDialog(this, "Client information not available. ");
                return;
            }
            // Try block for the main code logic
            printScreenPlan.setText(null);
            // set the fullName variable to the fullName classified in the start.
            txtFullName2.setText(client.getFullName());
            
            // Get and parse input values for target weight, squat count, plank, pushup, and treadmill
            String stringTargetWeight = txtTargetWeight.getText();
            int targetWeight = Integer.parseInt(stringTargetWeight);
            String stringSquatCount = txtInitialSquat.getText();
            int squatCount = Integer.parseInt(stringSquatCount);
            String stringPlank = txtInitialPlank.getText();
            int plank = Integer.parseInt(stringPlank);
            String stringPushup = txtInitialPushup.getText();
            int pushup = Integer.parseInt(stringPushup);
            String stringTreadmill = txtInitalTreadmill.getText();
            int treadmill = Integer.parseInt(stringTreadmill);
            // Check if any of the entered values (targetWeight, squatCount, plank, pushup, treadmill) are less than 0
            if ( squatCount < 0 || squatCount > 500 || plank < 0 || plank > 2000 || pushup < 0 || pushup > 200 || treadmill < 0 || treadmill > 3000) {
                // If any of the values are negative, set the text of jTextArea2 with an error message
                printScreenPlan.setText("Please enter values that are valid within human capabilities..");
                return;
            }
           
            // Create a new FitnessPlan object with the provided data
            fitness = new FitnessPlan(client, targetWeight, squatCount, plank, pushup, treadmill);
            // Display the fitness plan using the display() method and set the text of jTextArea1
            printScreenPlan.setText(fitness.display());
            
            // conditionals to ensure that the entered target weight is logically correct calculated BMI and weight.
            if (client.calculateBMI() > 25 && (targetWeight >= client.getWeightLbs())) {
                printScreenPlan.setText("Since you are overweight, your target must be below your actual weight. ");
                return;
            }else if (client.calculateBMI() < 18.5 && (targetWeight <= client.getWeightLbs())) {
                printScreenPlan.setText("Since you are underweight, your target must be above your actual weight. ");
                return;
            }if (client.calculateBMI() >= 18.5 && client.calculateBMI() <= 25) {
                double minAllowedWeight = client.getWeightLbs() - 10;
                double maxAllowedWeight = client.getWeightLbs() + 10;

                if (targetWeight >= minAllowedWeight && targetWeight <= maxAllowedWeight) {
                    // Target weight is within the allowed range
                    // Proceed with your logic here
                } else {
                    printScreenPlan.setText("Error: Since you are ideal weight, it is not safe to have target weight greater than the range of ±10 lbs from your current weight.");
                    return;
                }
                
            // conditionals to create limitations for the target weight in order to give limits to the user.
            }if ((targetWeight <= 140 || targetWeight > 300)&& client.calculateBMI() > 25) {
                printScreenPlan.setText("Please enter a possible target weight that is achieveable.");
                return;
            }if ((targetWeight >= 180 || targetWeight < 70) && client.calculateBMI() < 18.5) {
                printScreenPlan.setText("Please enter a possible target weight that will not lead to negative body consequences.");
                return;
            }
            
            
            // Update the clientArray with the new fitness plan information
            for (int i = 0; i<clientArray.size(); i++) {
                if (clientArray.get(i).contains(client.getFullName())) {
                    clientArray.add(i+1, "Starting Limits: " + fitness.toString());
                }
            }
            
            try {
                // Try block for writing updated clientArray to the "client.txt" file
               
                // Create a BufferedWriter to write to the "client.txt" file
                BufferedWriter writer = new BufferedWriter(new FileWriter("client.txt"));
                // Loop through each element (ok) in the clientArray
                for (String row : clientArray) {
                    // Write the current element (row) to the file
                    writer.write(row);
                   
                    // Write a newline character to separate each element
                    writer.write("\n");
                }
                // Close the writer to save changes and release resources
                writer.close();
            } catch (IOException ex) {
                // Catch block for handling IOException
               
                // If an IOException occurs (e.g., file write error), handle it
                ex.printStackTrace();
            }
        }catch (NumberFormatException nfe) {
            // Catch block for handling NumberFormatException
       
            // If a NumberFormatException occurs, set the text of jTextArea2 with an error message
            printScreenPlan.setText("Please enter a valid integer value for each of the inputs");
            return;
        }
        buttonWorkoutPlan.setEnabled(false);
        
    }
   
   
   
   
    // Method to track and display progress based on user inputs
    private void progressTracker( ArrayList<String> clientArray) {
        try {
            // Try block for the main code logic
           
            // Get the text entered in the jTextField7 (fullName3) field and store it in the fullName3 variable
            String fullName3 = txtFullName3.getText();
            
            if (fullName3.isEmpty() == true) {
                feedbackBox.setText("Please enter a valid full name.");
                return;
            }
           
            try{    
                // Try to parse fullName3 as a double value
                double parseTest = Double.parseDouble(fullName3);
               
                // Check if parseTest - parseTest is equal to 0
                // This condition checks if the input is a numeric value with no fractional part
                if (parseTest - parseTest == 0) {
                    // If the condition is met, set the text of jTextArea2 with an error message and return
                    feedbackBox.setText("Please enter a valid full name and not a different data type.");
                    return;
                }
            }catch (NumberFormatException nfe) {
                // Catch block for handling NumberFormatException
                // If fullName3 cannot be parsed as a double, do nothing (no action needed)
            }
           
            // Get the text entered in the jTextField8 (stringCurrentWeight) field and store it in the stringCurrentWeight variable
            String stringCurrentWeight = txtCurrentWeight.getText();
            // Convert the stringCurrentWeight to an integer value
            int currentWeight = Integer.parseInt(stringCurrentWeight);
            // Get the text entered in the jTextField9 (stringCurrentSquat) field and store it in the stringCurrentSquat variable
            String stringCurrentSquat = txtCurrentSquat.getText();
            // Convert the stringCurrentSquat to an integer value
            int currentSquat = Integer.parseInt(stringCurrentSquat);
            // Get the text entered in the jTextField10 (stringCurrentPlank) field and store it in the stringCurrentPlank variable
            String stringCurrentPlank = txtCurrentPlank.getText();
            // Convert the stringCurrentPlank to an integer value
            int currentPlank = Integer.parseInt(stringCurrentPlank);
            // Get the text entered in the jTextField11 (stringCurrentPushup) field and store it in the stringCurrentPushup variable
            String stringCurrentPushup = txtCurrentPushup.getText();
            // Convert the stringCurrentPushup to an integer value
            int currentPushup = Integer.parseInt(stringCurrentPushup);
            // Get the text entered in the jTextField12 (stringCurrentTreadmill) field and store it in the stringCurrentTreadmill variable
            String stringCurrentTreadmill = txtCurrentTread.getText();
            // Convert the stringCurrentTreadmill to an integer value
            int currentTreadmill = Integer.parseInt(stringCurrentTreadmill);
            // Check if any of the entered values (currentWeight, currentSquat, currentPlank, currentPushup, currentTreadmill) are less than 0
            if (currentWeight < 0 || currentSquat < 0 || currentPlank < 0 || currentPushup < 0 || currentTreadmill < 0) {
                 // If any of the values are negative, set the text of jTextArea2 with an error message
                feedbackBox.setText("Please enter a whole number greater than 0.");
                return;// Exit the method to prevent further processing
            }
            boolean found = false;
            // Loop through each element in the clientArray
            for (int i = 0; i<clientArray.size(); i++) {
                // Check if the current element contains the value of fullName3
                if (clientArray.get(i).contains(fullName3)) {
                    found = true;
                    // If the condition is met, extract the following element for further processing
                    String comparison = clientArray.get(i+1);
                    // Initialize an array to hold the extracted numbers
                    int[] numbersArray = new int[10]; // There are only 7 values
                    int index = 0;
                    // Define the separators for splitting the string
                    String separators = ",:{} \t"; // Define the separators including whitespace
                    // Split the comparison string using the defined separators
                    String[] parts = comparison.split("[^0-9.]+");
                    // Iterate through each part extracted from the string
                    for (String part : parts) {
                        // Check if the part is not empty
                        if (!part.isEmpty()) {
                            try {
                                // Try to parse the part as an integer and store it in the numbersArray
                                numbersArray[index] = Integer.parseInt(part);
                                index++;
                            } catch (NumberFormatException e) {
                                // Catch block to ignore parsing errors
                                // If the part cannot be parsed as an integer, ignore the error
                            }
                        }
                    }



                    // Create a new ProgressTracker object using the extracted numbers from the clientArray
                    ProgressTracker progress = new ProgressTracker(numbersArray[1], numbersArray[2], numbersArray[3], numbersArray[4], numbersArray[5], numbersArray[6], currentWeight, currentSquat, currentPlank, currentPushup, currentTreadmill);
                    // Set the text of the feedbackBox to display the weight difference using the weightDifference() method
                    feedbackBox.setText(progress.weightDifference());
                    // Update the clientArray with the new progress information
                    clientArray.add(i+1, "Current Limits: " + progress.toString());
                   
                   
                   
                }
            }
            if (found == false) {
                feedbackBox.setText("Please enter a valid name that has been initialized ");
                return;
            }
            // Try block for writing updated clientArray to the "client.txt" file
            try {
                // Create a BufferedWriter to write to the "client.txt" file
                BufferedWriter writer = new BufferedWriter(new FileWriter("client.txt"));
                // Loop through each element (row) in the clientArray
                for (String row : clientArray) {
                    // Write the current element (row) to the file                
                    writer.write(row);
                   
                    // Write a newline character to separate each element
                    writer.write("\n");
                }
                // Close the writer to save changes and release resources
                writer.close();
            } catch (IOException ex) {
                // Catch block for handling IOException
               
                // If an IOException occurs (e.g., file write error), handle it
                ex.printStackTrace();
            }
        // Catch block for handling NumberFormatException
        }catch (NumberFormatException nfe) {
            // If a NumberFormatException occurs, set the text of jTextArea2 with an error message
            feedbackBox.setText("Please enter a valid integer value for each of the inputs");
            return;
        }catch (IndexOutOfBoundsException nfe) {
            feedbackBox.setText("You have never even entered a fitness plan in the first place! Please redo the application.");
            return;
        }
        // setting button to false in order to not be seen again. 
        buttonProgress.setEnabled(false);
    }
   
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        tabbedPane1 = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        panel0Code = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        buttonExisting = new javax.swing.JButton();
        mainTitle2 = new javax.swing.JLabel();
        mainTitle1 = new javax.swing.JLabel();
        subTitle1 = new javax.swing.JLabel();
        instructionLbl1 = new javax.swing.JLabel();
        instructionLbl2 = new javax.swing.JLabel();
        buttonNew = new javax.swing.JButton();
        panel1Code = new javax.swing.JPanel();
        lblMedicalCondition = new javax.swing.JLabel();
        buttonMedYes = new javax.swing.JRadioButton();
        buttonNoMed = new javax.swing.JRadioButton();
        lblTypesMedical = new javax.swing.JLabel();
        txtMedicalCondition = new javax.swing.JTextField();
        lblAddictions = new javax.swing.JLabel();
        buttonAddictionYes = new javax.swing.JRadioButton();
        buttonAddictionNo = new javax.swing.JRadioButton();
        lblPregnant = new javax.swing.JLabel();
        tabTitle1 = new javax.swing.JLabel();
        buttonPregYes = new javax.swing.JRadioButton();
        lblPortfolio = new javax.swing.JLabel();
        txtHobby = new javax.swing.JTextField();
        lblHobby = new javax.swing.JLabel();
        txtFullName = new javax.swing.JTextField();
        lblGender = new javax.swing.JLabel();
        txtGender = new javax.swing.JTextField();
        buttonPregNo = new javax.swing.JRadioButton();
        lblDietPreference = new javax.swing.JLabel();
        dietComboBox = new javax.swing.JComboBox<>();
        txtHeightCm = new javax.swing.JTextField();
        txtWeightLbs = new javax.swing.JTextField();
        txtAgeNum = new javax.swing.JTextField();
        buttonCreateClient = new javax.swing.JButton();
        lblFullName = new javax.swing.JLabel();
        lblHeight = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        printScreen = new javax.swing.JTextArea();
        lblWeight = new javax.swing.JLabel();
        lblAge = new javax.swing.JLabel();
        lblErr = new javax.swing.JLabel();
        buttonNextPage1 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        printScreen1 = new javax.swing.JTextArea();
        lblErr1 = new javax.swing.JLabel();
        panel2Code = new javax.swing.JPanel();
        lblInstructions = new javax.swing.JLabel();
        lblInstructions2 = new javax.swing.JLabel();
        lblRecommend = new javax.swing.JLabel();
        txtCalorieIntake = new javax.swing.JTextField();
        lblRecommedn2 = new javax.swing.JLabel();
        txtDietaryPreference = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        lblPromptUser = new javax.swing.JLabel();
        txtMealSetInput = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtMealPlanArea = new javax.swing.JTextArea();
        lblFeedback = new javax.swing.JLabel();
        txtMessage = new javax.swing.JTextField();
        btnGenerateMealPlan = new javax.swing.JButton();
        programTitle2 = new javax.swing.JLabel();
        buttonNextPage2 = new javax.swing.JButton();
        panel3Code = new javax.swing.JPanel();
        txtFullName2 = new javax.swing.JTextField();
        lblTargetWeight = new javax.swing.JLabel();
        txtTargetWeight = new javax.swing.JTextField();
        lblSquatCount = new javax.swing.JLabel();
        txtInitialSquat = new javax.swing.JTextField();
        lblPlankTime = new javax.swing.JLabel();
        txtInitialPlank = new javax.swing.JTextField();
        lblPushupCount = new javax.swing.JLabel();
        txtInitialPushup = new javax.swing.JTextField();
        lblTreadmillTime = new javax.swing.JLabel();
        txtInitalTreadmill = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        printScreenPlan = new javax.swing.JTextArea();
        buttonWorkoutPlan = new javax.swing.JButton();
        programTitle3 = new javax.swing.JLabel();
        lblFeedbackErrors = new javax.swing.JLabel();
        lblInstructions4 = new javax.swing.JLabel();
        lblInstructions5 = new javax.swing.JLabel();
        lblInstructions6 = new javax.swing.JLabel();
        buttonNextPage3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        lblWaterIntake = new javax.swing.JLabel();
        txtWaterIntake = new javax.swing.JTextField();
        lblAvgSleep = new javax.swing.JLabel();
        txtAvgSleep = new javax.swing.JTextField();
        lblExhaustingDay = new javax.swing.JLabel();
        txtExhaustingDay = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtWaterFeedback = new javax.swing.JTextArea();
        lblErrFeedback = new javax.swing.JLabel();
        buttonWaterSleep = new javax.swing.JButton();
        lblInstructions7 = new javax.swing.JLabel();
        lblInstructions8 = new javax.swing.JLabel();
        lblInstructions9 = new javax.swing.JLabel();
        programTitle4 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        congratsMessage = new javax.swing.JTextArea();
        exitButton = new javax.swing.JButton();
        panel5Code = new javax.swing.JPanel();
        txtCurrentSquat = new javax.swing.JTextField();
        txtCurrentTread = new javax.swing.JTextField();
        lblCurrentTreadmill = new javax.swing.JLabel();
        txtCurrentPushup = new javax.swing.JTextField();
        lblCurrentPushup = new javax.swing.JLabel();
        txtCurrentPlank = new javax.swing.JTextField();
        lblCurrentPlank = new javax.swing.JLabel();
        txtFullName3 = new javax.swing.JTextField();
        lblFullName3 = new javax.swing.JLabel();
        lblCurrentWeight = new javax.swing.JLabel();
        txtCurrentWeight = new javax.swing.JTextField();
        lblCurrentSquat = new javax.swing.JLabel();
        lblErrorsFeed = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        feedbackBox = new javax.swing.JTextArea();
        buttonProgress = new javax.swing.JButton();
        programTitle5 = new javax.swing.JLabel();
        lblInstructions10 = new javax.swing.JLabel();
        lblInstructions11 = new javax.swing.JLabel();
        lblHistoryReminder = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Health And Fitness Tracker");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel0Code.setBackground(new java.awt.Color(0, 0, 102));

        jButton1.setText("Next");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        buttonExisting.setBackground(new java.awt.Color(255, 255, 153));
        buttonExisting.setFont(new java.awt.Font("American Typewriter", 1, 14)); // NOI18N
        buttonExisting.setText("Progress Tracker");
        buttonExisting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExistingActionPerformed(evt);
            }
        });

        mainTitle2.setFont(new java.awt.Font("Kefa", 1, 48)); // NOI18N
        mainTitle2.setForeground(new java.awt.Color(204, 204, 255));
        mainTitle2.setText("TRACKER APPLICATION");

        mainTitle1.setFont(new java.awt.Font("Kefa", 1, 48)); // NOI18N
        mainTitle1.setForeground(new java.awt.Color(204, 204, 255));
        mainTitle1.setText("HEALTH AND FITNESS");

        subTitle1.setFont(new java.awt.Font("Source Code Pro", 1, 24)); // NOI18N
        subTitle1.setForeground(new java.awt.Color(255, 204, 204));
        subTitle1.setText("By: Akshayan, Manvi, Bavishan");

        instructionLbl1.setForeground(new java.awt.Color(255, 255, 255));
        instructionLbl1.setText("Click if you have an existing portfolio:");

        instructionLbl2.setForeground(new java.awt.Color(255, 255, 255));
        instructionLbl2.setText("Click Here to Create A Portfolio:");

        buttonNew.setBackground(new java.awt.Color(255, 255, 153));
        buttonNew.setFont(new java.awt.Font("American Typewriter", 1, 14)); // NOI18N
        buttonNew.setText("Next");
        buttonNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel0CodeLayout = new javax.swing.GroupLayout(panel0Code);
        panel0Code.setLayout(panel0CodeLayout);
        panel0CodeLayout.setHorizontalGroup(
            panel0CodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel0CodeLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(buttonExisting)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonNew)
                .addGap(206, 206, 206)
                .addComponent(jButton1)
                .addGap(23, 23, 23))
            .addGroup(panel0CodeLayout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addGroup(panel0CodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mainTitle2, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel0CodeLayout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(subTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(339, Short.MAX_VALUE))
            .addGroup(panel0CodeLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(instructionLbl1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(instructionLbl2)
                .addGap(257, 257, 257))
            .addGroup(panel0CodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panel0CodeLayout.createSequentialGroup()
                    .addGap(144, 144, 144)
                    .addComponent(mainTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(369, Short.MAX_VALUE)))
        );
        panel0CodeLayout.setVerticalGroup(
            panel0CodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel0CodeLayout.createSequentialGroup()
                .addContainerGap(180, Short.MAX_VALUE)
                .addComponent(mainTitle2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(subTitle1)
                .addGap(94, 94, 94)
                .addGroup(panel0CodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(instructionLbl1)
                    .addComponent(instructionLbl2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel0CodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonExisting)
                    .addComponent(jButton1)
                    .addComponent(buttonNew))
                .addGap(9, 9, 9))
            .addGroup(panel0CodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panel0CodeLayout.createSequentialGroup()
                    .addGap(95, 95, 95)
                    .addComponent(mainTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(257, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel0Code, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel0Code, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(124, Short.MAX_VALUE))
        );

        tabbedPane1.addTab("tab0", jPanel7);

        lblMedicalCondition.setFont(new java.awt.Font("Malayalam MN", 1, 13)); // NOI18N
        lblMedicalCondition.setForeground(new java.awt.Color(0, 0, 153));
        lblMedicalCondition.setText("Medical Condition:");

        buttonMedYes.setBackground(new java.awt.Color(255, 255, 153));
        buttonGroup1.add(buttonMedYes);
        buttonMedYes.setFont(new java.awt.Font("American Typewriter", 1, 13)); // NOI18N
        buttonMedYes.setText("Yes");

        buttonNoMed.setBackground(new java.awt.Color(255, 255, 153));
        buttonGroup1.add(buttonNoMed);
        buttonNoMed.setFont(new java.awt.Font("American Typewriter", 1, 13)); // NOI18N
        buttonNoMed.setText("No");

        lblTypesMedical.setFont(new java.awt.Font("Malayalam MN", 1, 13)); // NOI18N
        lblTypesMedical.setForeground(new java.awt.Color(0, 0, 153));
        lblTypesMedical.setText("If Yes, Indicate any in the textfield:");

        txtMedicalCondition.setBackground(new java.awt.Color(204, 255, 255));

        lblAddictions.setFont(new java.awt.Font("Malayalam MN", 1, 13)); // NOI18N
        lblAddictions.setForeground(new java.awt.Color(0, 0, 153));
        lblAddictions.setText("Addictions (Smoking, Alcohol, Drugs):");

        buttonAddictionYes.setBackground(new java.awt.Color(255, 255, 153));
        buttonGroup3.add(buttonAddictionYes);
        buttonAddictionYes.setFont(new java.awt.Font("American Typewriter", 1, 13)); // NOI18N
        buttonAddictionYes.setText("Yes");

        buttonAddictionNo.setBackground(new java.awt.Color(255, 255, 153));
        buttonGroup3.add(buttonAddictionNo);
        buttonAddictionNo.setFont(new java.awt.Font("American Typewriter", 1, 13)); // NOI18N
        buttonAddictionNo.setText("No");

        lblPregnant.setFont(new java.awt.Font("Malayalam MN", 1, 13)); // NOI18N
        lblPregnant.setForeground(new java.awt.Color(0, 0, 153));
        lblPregnant.setText("Pregnant?");

        tabTitle1.setFont(new java.awt.Font("Kefa", 1, 15)); // NOI18N
        tabTitle1.setForeground(new java.awt.Color(0, 153, 153));
        tabTitle1.setText("Health and Fitness Tracker");

        buttonPregYes.setBackground(new java.awt.Color(255, 255, 153));
        buttonGroup2.add(buttonPregYes);
        buttonPregYes.setFont(new java.awt.Font("American Typewriter", 1, 13)); // NOI18N
        buttonPregYes.setText("Yes");

        lblPortfolio.setFont(new java.awt.Font("Malayalam MN", 1, 13)); // NOI18N
        lblPortfolio.setForeground(new java.awt.Color(0, 0, 153));
        lblPortfolio.setText("Creating A New Client Portfolio:");

        txtHobby.setBackground(new java.awt.Color(204, 255, 255));

        lblHobby.setFont(new java.awt.Font("Malayalam MN", 1, 13)); // NOI18N
        lblHobby.setForeground(new java.awt.Color(0, 0, 153));
        lblHobby.setText("Outdoor Hobby:");

        txtFullName.setBackground(new java.awt.Color(204, 255, 255));

        lblGender.setFont(new java.awt.Font("Malayalam MN", 1, 13)); // NOI18N
        lblGender.setForeground(new java.awt.Color(0, 0, 153));
        lblGender.setText("Gender(M/F):");

        txtGender.setBackground(new java.awt.Color(204, 255, 255));

        buttonPregNo.setBackground(new java.awt.Color(255, 255, 153));
        buttonGroup2.add(buttonPregNo);
        buttonPregNo.setFont(new java.awt.Font("American Typewriter", 1, 13)); // NOI18N
        buttonPregNo.setText("No");

        lblDietPreference.setFont(new java.awt.Font("Malayalam MN", 1, 13)); // NOI18N
        lblDietPreference.setForeground(new java.awt.Color(0, 0, 153));
        lblDietPreference.setText("Diet Preferences:");

        dietComboBox.setBackground(new java.awt.Color(255, 255, 153));
        dietComboBox.setFont(new java.awt.Font("American Typewriter", 1, 13)); // NOI18N
        dietComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Vegan", "Vegetarian", "Gluten-Free", "Dairy Free", " " }));

        txtHeightCm.setBackground(new java.awt.Color(204, 255, 255));

        txtWeightLbs.setBackground(new java.awt.Color(204, 255, 255));

        txtAgeNum.setBackground(new java.awt.Color(204, 255, 255));

        buttonCreateClient.setBackground(new java.awt.Color(255, 255, 153));
        buttonCreateClient.setFont(new java.awt.Font("American Typewriter", 1, 13)); // NOI18N
        buttonCreateClient.setText("Create Client");
        buttonCreateClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCreateClientActionPerformed(evt);
            }
        });

        lblFullName.setFont(new java.awt.Font("Malayalam MN", 1, 13)); // NOI18N
        lblFullName.setForeground(new java.awt.Color(0, 0, 153));
        lblFullName.setText("Full Name:");

        lblHeight.setFont(new java.awt.Font("Malayalam MN", 1, 13)); // NOI18N
        lblHeight.setForeground(new java.awt.Color(0, 0, 153));
        lblHeight.setText("Height(Cm):");

        printScreen.setEditable(false);
        printScreen.setBackground(new java.awt.Color(102, 255, 255));
        printScreen.setColumns(20);
        printScreen.setRows(5);
        jScrollPane3.setViewportView(printScreen);

        lblWeight.setFont(new java.awt.Font("Malayalam MN", 1, 13)); // NOI18N
        lblWeight.setForeground(new java.awt.Color(0, 0, 153));
        lblWeight.setText("Weight Integer(lbs):");

        lblAge.setFont(new java.awt.Font("Malayalam MN", 1, 13)); // NOI18N
        lblAge.setForeground(new java.awt.Color(0, 0, 153));
        lblAge.setText("Age:");

        lblErr.setFont(new java.awt.Font("Malayalam MN", 1, 13)); // NOI18N
        lblErr.setForeground(new java.awt.Color(0, 0, 153));
        lblErr.setText("Errors:");

        buttonNextPage1.setBackground(new java.awt.Color(255, 255, 153));
        buttonNextPage1.setFont(new java.awt.Font("American Typewriter", 1, 13)); // NOI18N
        buttonNextPage1.setText("Next Page");
        buttonNextPage1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNextPage1ActionPerformed(evt);
            }
        });

        printScreen1.setEditable(false);
        printScreen1.setBackground(new java.awt.Color(102, 255, 255));
        printScreen1.setColumns(20);
        printScreen1.setRows(5);
        jScrollPane6.setViewportView(printScreen1);

        lblErr1.setFont(new java.awt.Font("Malayalam MN", 1, 13)); // NOI18N
        lblErr1.setForeground(new java.awt.Color(0, 0, 153));
        lblErr1.setText("Feedback:");

        javax.swing.GroupLayout panel1CodeLayout = new javax.swing.GroupLayout(panel1Code);
        panel1Code.setLayout(panel1CodeLayout);
        panel1CodeLayout.setHorizontalGroup(
            panel1CodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1CodeLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(panel1CodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel1CodeLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panel1CodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel1CodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(panel1CodeLayout.createSequentialGroup()
                                    .addGroup(panel1CodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(panel1CodeLayout.createSequentialGroup()
                                            .addComponent(lblHeight)
                                            .addGap(5, 5, 5))
                                        .addGroup(panel1CodeLayout.createSequentialGroup()
                                            .addComponent(lblFullName)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                    .addGroup(panel1CodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtHeightCm, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtFullName, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel1CodeLayout.createSequentialGroup()
                                    .addComponent(lblAge)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtAgeNum, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panel1CodeLayout.createSequentialGroup()
                                .addComponent(lblGender)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtGender, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel1CodeLayout.createSequentialGroup()
                                .addComponent(lblHobby)
                                .addGap(18, 18, 18)
                                .addComponent(txtHobby, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(669, 669, 669))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel1CodeLayout.createSequentialGroup()
                        .addComponent(lblWeight)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtWeightLbs, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(panel1CodeLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panel1CodeLayout.createSequentialGroup()
                .addGroup(panel1CodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1CodeLayout.createSequentialGroup()
                        .addGap(332, 332, 332)
                        .addGroup(panel1CodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel1CodeLayout.createSequentialGroup()
                                .addComponent(lblPregnant)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttonPregYes)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonPregNo))
                            .addGroup(panel1CodeLayout.createSequentialGroup()
                                .addGroup(panel1CodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(panel1CodeLayout.createSequentialGroup()
                                        .addComponent(lblDietPreference)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(dietComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel1CodeLayout.createSequentialGroup()
                                        .addComponent(lblAddictions)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(buttonAddictionYes)))
                                .addGap(18, 18, 18)
                                .addComponent(buttonAddictionNo))))
                    .addGroup(panel1CodeLayout.createSequentialGroup()
                        .addGap(298, 298, 298)
                        .addComponent(tabTitle1))
                    .addGroup(panel1CodeLayout.createSequentialGroup()
                        .addGroup(panel1CodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel1CodeLayout.createSequentialGroup()
                                .addGap(450, 450, 450)
                                .addComponent(buttonNextPage1))
                            .addGroup(panel1CodeLayout.createSequentialGroup()
                                .addGap(192, 192, 192)
                                .addComponent(lblErr)))
                        .addGap(18, 18, 18)
                        .addGroup(panel1CodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblErr1)
                            .addComponent(buttonCreateClient))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panel1CodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panel1CodeLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblPortfolio)
                    .addGap(105, 105, 105)
                    .addGroup(panel1CodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panel1CodeLayout.createSequentialGroup()
                            .addComponent(lblMedicalCondition)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(buttonMedYes)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(buttonNoMed))
                        .addGroup(panel1CodeLayout.createSequentialGroup()
                            .addGap(36, 36, 36)
                            .addGroup(panel1CodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblTypesMedical, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                                .addComponent(txtMedicalCondition))))
                    .addContainerGap(343, Short.MAX_VALUE)))
        );
        panel1CodeLayout.setVerticalGroup(
            panel1CodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1CodeLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(tabTitle1)
                .addGap(50, 50, 50)
                .addGroup(panel1CodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFullName)
                    .addComponent(txtFullName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel1CodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGender))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel1CodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHeight)
                    .addComponent(txtHeightCm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDietPreference)
                    .addComponent(dietComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(panel1CodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonPregNo)
                    .addComponent(buttonPregYes)
                    .addComponent(lblPregnant)
                    .addComponent(lblWeight)
                    .addComponent(txtWeightLbs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(panel1CodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1CodeLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(panel1CodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAddictions)
                            .addComponent(buttonAddictionYes)
                            .addComponent(buttonAddictionNo)))
                    .addGroup(panel1CodeLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(panel1CodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAge)
                            .addComponent(txtAgeNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(panel1CodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1CodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblHobby)
                        .addComponent(txtHobby, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel1CodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonCreateClient)
                        .addComponent(buttonNextPage1)))
                .addGap(37, 37, 37)
                .addGroup(panel1CodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblErr)
                    .addComponent(lblErr1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel1CodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addContainerGap(101, Short.MAX_VALUE))
            .addGroup(panel1CodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panel1CodeLayout.createSequentialGroup()
                    .addGroup(panel1CodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel1CodeLayout.createSequentialGroup()
                            .addGap(48, 48, 48)
                            .addComponent(lblPortfolio))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel1CodeLayout.createSequentialGroup()
                            .addGap(42, 42, 42)
                            .addGroup(panel1CodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblMedicalCondition)
                                .addComponent(buttonMedYes)
                                .addComponent(buttonNoMed))
                            .addGap(7, 7, 7)
                            .addComponent(lblTypesMedical)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtMedicalCondition, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(449, Short.MAX_VALUE)))
        );

        tabbedPane1.addTab("tab1", panel1Code);

        lblInstructions.setFont(new java.awt.Font("Malayalam MN", 1, 14)); // NOI18N
        lblInstructions.setText("Generate your own personalized meal set options based off your user portfolio requirements and preferences!");

        lblInstructions2.setFont(new java.awt.Font("Malayalam MN", 1, 14)); // NOI18N
        lblInstructions2.setText("Whether it be just for a day or even a week, you got this!");

        lblRecommend.setFont(new java.awt.Font("Malayalam MN", 1, 14)); // NOI18N
        lblRecommend.setText("Your recommended daily calorie intake (based off given data):");

        txtCalorieIntake.setEditable(false);
        txtCalorieIntake.setBackground(new java.awt.Color(153, 255, 255));

        lblRecommedn2.setFont(new java.awt.Font("Malayalam MN", 1, 14)); // NOI18N
        lblRecommedn2.setText("Your chosen dietary preference:");

        txtDietaryPreference.setEditable(false);
        txtDietaryPreference.setBackground(new java.awt.Color(153, 255, 255));

        jLabel20.setText("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");

        lblPromptUser.setFont(new java.awt.Font("Malayalam MN", 1, 14)); // NOI18N
        lblPromptUser.setText("Please enter how many meal sets you would like to generate for yourself (between 1 to 7):");

        txtMealSetInput.setBackground(new java.awt.Color(204, 255, 255));

        txtMealPlanArea.setEditable(false);
        txtMealPlanArea.setBackground(new java.awt.Color(153, 255, 255));
        txtMealPlanArea.setColumns(20);
        txtMealPlanArea.setRows(5);
        jScrollPane4.setViewportView(txtMealPlanArea);

        lblFeedback.setFont(new java.awt.Font("Malayalam MN", 1, 14)); // NOI18N
        lblFeedback.setText("Feedback:");

        txtMessage.setEditable(false);
        txtMessage.setBackground(new java.awt.Color(153, 255, 255));

        btnGenerateMealPlan.setBackground(new java.awt.Color(255, 255, 153));
        btnGenerateMealPlan.setFont(new java.awt.Font("American Typewriter", 1, 14)); // NOI18N
        btnGenerateMealPlan.setText("Generate Meal Plan");
        btnGenerateMealPlan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateMealPlanActionPerformed(evt);
            }
        });

        programTitle2.setFont(new java.awt.Font("Kefa", 1, 15)); // NOI18N
        programTitle2.setForeground(new java.awt.Color(0, 153, 153));
        programTitle2.setText("Health and Fitness Tracker");

        buttonNextPage2.setBackground(new java.awt.Color(255, 255, 153));
        buttonNextPage2.setFont(new java.awt.Font("American Typewriter", 1, 14)); // NOI18N
        buttonNextPage2.setText("Next");
        buttonNextPage2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNextPage2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel2CodeLayout = new javax.swing.GroupLayout(panel2Code);
        panel2Code.setLayout(panel2CodeLayout);
        panel2CodeLayout.setHorizontalGroup(
            panel2CodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2CodeLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(panel2CodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel2CodeLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(panel2CodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPromptUser)
                            .addGroup(panel2CodeLayout.createSequentialGroup()
                                .addComponent(lblRecommend)
                                .addGap(18, 18, 18)
                                .addComponent(txtCalorieIntake, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel2CodeLayout.createSequentialGroup()
                                .addComponent(lblRecommedn2)
                                .addGap(29, 29, 29)
                                .addComponent(txtDietaryPreference, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panel2CodeLayout.createSequentialGroup()
                                .addGap(132, 132, 132)
                                .addComponent(lblInstructions2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lblInstructions, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(84, 84, 84))
            .addGroup(panel2CodeLayout.createSequentialGroup()
                .addGroup(panel2CodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel2CodeLayout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addGroup(panel2CodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel2CodeLayout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(txtMealSetInput, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(96, 96, 96)
                                .addComponent(btnGenerateMealPlan))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panel2CodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel2CodeLayout.createSequentialGroup()
                                    .addComponent(lblFeedback)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(buttonNextPage2))
                                .addComponent(txtMessage, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panel2CodeLayout.createSequentialGroup()
                        .addGap(279, 279, 279)
                        .addComponent(programTitle2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel2CodeLayout.setVerticalGroup(
            panel2CodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2CodeLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(programTitle2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblInstructions)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblInstructions2)
                .addGap(18, 18, 18)
                .addGroup(panel2CodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRecommend)
                    .addComponent(txtCalorieIntake, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(panel2CodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRecommedn2)
                    .addComponent(txtDietaryPreference, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPromptUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel2CodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGenerateMealPlan)
                    .addComponent(txtMealSetInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panel2CodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFeedback)
                    .addComponent(buttonNextPage2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(140, Short.MAX_VALUE))
        );

        tabbedPane1.addTab("tab2", panel2Code);

        txtFullName2.setEditable(false);
        txtFullName2.setBackground(new java.awt.Color(153, 255, 255));

        lblTargetWeight.setFont(new java.awt.Font("Malayalam MN", 1, 14)); // NOI18N
        lblTargetWeight.setText("Target Weight (lbs):");

        txtTargetWeight.setBackground(new java.awt.Color(204, 255, 255));

        lblSquatCount.setFont(new java.awt.Font("Malayalam MN", 1, 14)); // NOI18N
        lblSquatCount.setText("Initial Squat Count:");

        txtInitialSquat.setBackground(new java.awt.Color(204, 255, 255));

        lblPlankTime.setFont(new java.awt.Font("Malayalam MN", 1, 14)); // NOI18N
        lblPlankTime.setText("Initial Plank Time in Seconds:");

        txtInitialPlank.setBackground(new java.awt.Color(204, 255, 255));

        lblPushupCount.setFont(new java.awt.Font("Malayalam MN", 1, 14)); // NOI18N
        lblPushupCount.setText("Initial Pushup Count:");

        txtInitialPushup.setBackground(new java.awt.Color(204, 255, 255));

        lblTreadmillTime.setFont(new java.awt.Font("Malayalam MN", 1, 14)); // NOI18N
        lblTreadmillTime.setText("Initial Treadmill Duration at 7.5mph (seconds):");

        txtInitalTreadmill.setBackground(new java.awt.Color(204, 255, 255));

        printScreenPlan.setEditable(false);
        printScreenPlan.setBackground(new java.awt.Color(153, 255, 255));
        printScreenPlan.setColumns(20);
        printScreenPlan.setRows(5);
        jScrollPane2.setViewportView(printScreenPlan);

        buttonWorkoutPlan.setBackground(new java.awt.Color(255, 255, 153));
        buttonWorkoutPlan.setFont(new java.awt.Font("American Typewriter", 1, 14)); // NOI18N
        buttonWorkoutPlan.setText("Generate my workout plan!");
        buttonWorkoutPlan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonWorkoutPlanActionPerformed(evt);
            }
        });

        programTitle3.setFont(new java.awt.Font("Kefa", 1, 15)); // NOI18N
        programTitle3.setForeground(new java.awt.Color(0, 153, 153));
        programTitle3.setText("Health and Fitness Tracker");

        lblFeedbackErrors.setFont(new java.awt.Font("Malayalam MN", 1, 14)); // NOI18N
        lblFeedbackErrors.setText("Feedback/Errors");

        lblInstructions4.setFont(new java.awt.Font("Malayalam MN", 1, 14)); // NOI18N
        lblInstructions4.setText("Fitness Plan: This part of the application process will generate a personalized workout plan based off");

        lblInstructions5.setFont(new java.awt.Font("Malayalam MN", 1, 14)); // NOI18N
        lblInstructions5.setText("calculations made for your needs, such as your BMI, age etc. Please save and follow this 7 day");

        lblInstructions6.setFont(new java.awt.Font("Malayalam MN", 1, 14)); // NOI18N
        lblInstructions6.setText("workout in order to see great changes in your physique to promote a healthier lifestyle.");

        buttonNextPage3.setBackground(new java.awt.Color(255, 255, 153));
        buttonNextPage3.setFont(new java.awt.Font("American Typewriter", 1, 14)); // NOI18N
        buttonNextPage3.setText("Next");
        buttonNextPage3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNextPage3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel3CodeLayout = new javax.swing.GroupLayout(panel3Code);
        panel3Code.setLayout(panel3CodeLayout);
        panel3CodeLayout.setHorizontalGroup(
            panel3CodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3CodeLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(panel3CodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel3CodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblInstructions6)
                        .addGroup(panel3CodeLayout.createSequentialGroup()
                            .addGroup(panel3CodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panel3CodeLayout.createSequentialGroup()
                                    .addGap(1, 1, 1)
                                    .addComponent(lblPushupCount)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtInitialPushup, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(panel3CodeLayout.createSequentialGroup()
                                    .addComponent(lblTargetWeight)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtTargetWeight, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(panel3CodeLayout.createSequentialGroup()
                                    .addGap(13, 13, 13)
                                    .addComponent(txtFullName2, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panel3CodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panel3CodeLayout.createSequentialGroup()
                                    .addComponent(lblPlankTime)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtInitialPlank, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(lblFeedbackErrors)
                                .addGroup(panel3CodeLayout.createSequentialGroup()
                                    .addComponent(lblSquatCount)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtInitialSquat, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(panel3CodeLayout.createSequentialGroup()
                                    .addComponent(lblTreadmillTime)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtInitalTreadmill, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(panel3CodeLayout.createSequentialGroup()
                            .addGap(238, 238, 238)
                            .addComponent(programTitle3)))
                    .addComponent(lblInstructions4))
                .addGap(35, 59, Short.MAX_VALUE))
            .addGroup(panel3CodeLayout.createSequentialGroup()
                .addGroup(panel3CodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel3CodeLayout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(lblInstructions5))
                    .addGroup(panel3CodeLayout.createSequentialGroup()
                        .addGap(306, 306, 306)
                        .addComponent(buttonWorkoutPlan)
                        .addGap(59, 59, 59)
                        .addComponent(buttonNextPage3)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel3CodeLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(127, 127, 127))
        );
        panel3CodeLayout.setVerticalGroup(
            panel3CodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel3CodeLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(programTitle3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblInstructions4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblInstructions5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblInstructions6)
                .addGap(28, 28, 28)
                .addGroup(panel3CodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSquatCount)
                    .addComponent(txtInitialSquat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFullName2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel3CodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTargetWeight)
                    .addComponent(txtTargetWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPlankTime)
                    .addComponent(txtInitialPlank, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addGroup(panel3CodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPushupCount)
                    .addComponent(txtInitialPushup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTreadmillTime)
                    .addComponent(txtInitalTreadmill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel3CodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonWorkoutPlan)
                    .addComponent(buttonNextPage3))
                .addGap(18, 18, 18)
                .addComponent(lblFeedbackErrors)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
        );

        tabbedPane1.addTab("tab3", panel3Code);

        lblWaterIntake.setFont(new java.awt.Font("Tamil MN", 1, 18)); // NOI18N
        lblWaterIntake.setForeground(new java.awt.Color(0, 0, 153));
        lblWaterIntake.setText("Daily Water Intake(ounces): ");

        txtWaterIntake.setBackground(new java.awt.Color(204, 255, 255));
        txtWaterIntake.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtWaterIntakeActionPerformed(evt);
            }
        });

        lblAvgSleep.setFont(new java.awt.Font("Tamil MN", 1, 18)); // NOI18N
        lblAvgSleep.setForeground(new java.awt.Color(0, 0, 153));
        lblAvgSleep.setText("Average sleep duration(hrs): ");

        txtAvgSleep.setBackground(new java.awt.Color(204, 255, 255));

        lblExhaustingDay.setFont(new java.awt.Font("Tamil MN", 1, 18)); // NOI18N
        lblExhaustingDay.setForeground(new java.awt.Color(0, 0, 153));
        lblExhaustingDay.setText("Did you have a physically exhausting day(Yes/No)?");

        txtExhaustingDay.setBackground(new java.awt.Color(204, 255, 255));

        txtWaterFeedback.setEditable(false);
        txtWaterFeedback.setBackground(new java.awt.Color(102, 255, 255));
        txtWaterFeedback.setColumns(20);
        txtWaterFeedback.setRows(5);
        jScrollPane5.setViewportView(txtWaterFeedback);

        lblErrFeedback.setFont(new java.awt.Font("Tamil MN", 1, 15)); // NOI18N
        lblErrFeedback.setForeground(new java.awt.Color(0, 0, 153));
        lblErrFeedback.setText("Feedback/Errors");

        buttonWaterSleep.setBackground(new java.awt.Color(255, 255, 153));
        buttonWaterSleep.setFont(new java.awt.Font("American Typewriter", 1, 14)); // NOI18N
        buttonWaterSleep.setText("Check Water and Sleep Now!");
        buttonWaterSleep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonWaterSleepActionPerformed(evt);
            }
        });

        lblInstructions7.setFont(new java.awt.Font("Kohinoor Bangla", 1, 14)); // NOI18N
        lblInstructions7.setText("Water and Sleep Activity Monitor: It is always important to ensure that we are getting enough sleep and water");

        lblInstructions8.setFont(new java.awt.Font("Kohinoor Bangla", 1, 14)); // NOI18N
        lblInstructions8.setText("in order for our body to properly heal after the workout plans, ensure maximum organ function, and have all");

        lblInstructions9.setFont(new java.awt.Font("Kohinoor Bangla", 1, 14)); // NOI18N
        lblInstructions9.setText("required nutrients to create a healthier lifestyle.");

        programTitle4.setFont(new java.awt.Font("Kefa", 1, 15)); // NOI18N
        programTitle4.setForeground(new java.awt.Color(0, 153, 153));
        programTitle4.setText("Health and Fitness Tracker");

        congratsMessage.setEditable(false);
        congratsMessage.setBackground(new java.awt.Color(102, 255, 255));
        congratsMessage.setColumns(20);
        congratsMessage.setRows(5);
        jScrollPane7.setViewportView(congratsMessage);

        exitButton.setBackground(new java.awt.Color(255, 255, 153));
        exitButton.setFont(new java.awt.Font("American Typewriter", 1, 14)); // NOI18N
        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(317, 317, 317)
                        .addComponent(programTitle4))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(216, 216, 216)
                        .addComponent(lblInstructions9)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblExhaustingDay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(exitButton)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(txtExhaustingDay, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(32, 32, 32)
                                                .addComponent(buttonWaterSleep)))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(45, 45, 45))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(lblWaterIntake)
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtAvgSleep, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                                            .addComponent(txtWaterIntake)))
                                    .addComponent(lblAvgSleep, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(lblErrFeedback)
                                .addGap(128, 128, 128))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(lblInstructions8))
                            .addComponent(lblInstructions7))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(programTitle4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblInstructions7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblInstructions8)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(lblErrFeedback)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(186, 186, 186))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(lblInstructions9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblWaterIntake)
                            .addComponent(txtWaterIntake, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblAvgSleep)
                                    .addComponent(txtAvgSleep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblExhaustingDay)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtExhaustingDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(buttonWaterSleep)))
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(exitButton)
                        .addGap(252, 252, 252))))
        );

        tabbedPane1.addTab("tab4", jPanel3);

        txtCurrentSquat.setBackground(new java.awt.Color(204, 255, 255));

        txtCurrentTread.setBackground(new java.awt.Color(204, 255, 255));

        lblCurrentTreadmill.setFont(new java.awt.Font("Malayalam MN", 1, 14)); // NOI18N
        lblCurrentTreadmill.setText("Current Treadmill Duration at 7.5mph (seconds):");

        txtCurrentPushup.setBackground(new java.awt.Color(204, 255, 255));

        lblCurrentPushup.setFont(new java.awt.Font("Malayalam MN", 1, 14)); // NOI18N
        lblCurrentPushup.setText("Current Pushup Count:");

        txtCurrentPlank.setBackground(new java.awt.Color(204, 255, 255));

        lblCurrentPlank.setFont(new java.awt.Font("Malayalam MN", 1, 14)); // NOI18N
        lblCurrentPlank.setText("Current Plank Time in Seconds:");

        txtFullName3.setBackground(new java.awt.Color(204, 255, 255));

        lblFullName3.setFont(new java.awt.Font("Malayalam MN", 1, 14)); // NOI18N
        lblFullName3.setText("Full Name:");

        lblCurrentWeight.setFont(new java.awt.Font("Malayalam MN", 1, 14)); // NOI18N
        lblCurrentWeight.setText("Current Weight (lbs):");

        txtCurrentWeight.setBackground(new java.awt.Color(204, 255, 255));

        lblCurrentSquat.setFont(new java.awt.Font("Malayalam MN", 1, 14)); // NOI18N
        lblCurrentSquat.setText("Current Squat Count:");

        lblErrorsFeed.setFont(new java.awt.Font("Malayalam MN", 1, 14)); // NOI18N
        lblErrorsFeed.setText("Feedback/Errors");

        feedbackBox.setEditable(false);
        feedbackBox.setBackground(new java.awt.Color(153, 255, 255));
        feedbackBox.setColumns(20);
        feedbackBox.setRows(5);
        jScrollPane1.setViewportView(feedbackBox);

        buttonProgress.setBackground(new java.awt.Color(255, 255, 153));
        buttonProgress.setFont(new java.awt.Font("American Typewriter", 1, 14)); // NOI18N
        buttonProgress.setText("Find my progress!");
        buttonProgress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonProgressActionPerformed(evt);
            }
        });

        programTitle5.setFont(new java.awt.Font("Kefa", 1, 15)); // NOI18N
        programTitle5.setForeground(new java.awt.Color(0, 153, 153));
        programTitle5.setText("Health and Fitness Tracker");

        lblInstructions10.setFont(new java.awt.Font("Malayalam MN", 1, 14)); // NOI18N
        lblInstructions10.setText("Progress Tracker: From your existing portfolio, you will be able to update your progress on your weight and");

        lblInstructions11.setFont(new java.awt.Font("Malayalam MN", 1, 14)); // NOI18N
        lblInstructions11.setText("certain key exercises that will show your progress! This is great to give you reference on your health journey.");

        lblHistoryReminder.setFont(new java.awt.Font("Malayalam MN", 1, 14)); // NOI18N
        lblHistoryReminder.setText("Check client.txt for progress history!");

        javax.swing.GroupLayout panel5CodeLayout = new javax.swing.GroupLayout(panel5Code);
        panel5Code.setLayout(panel5CodeLayout);
        panel5CodeLayout.setHorizontalGroup(
            panel5CodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel5CodeLayout.createSequentialGroup()
                .addGroup(panel5CodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel5CodeLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(panel5CodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel5CodeLayout.createSequentialGroup()
                                .addComponent(lblCurrentWeight)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCurrentWeight, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel5CodeLayout.createSequentialGroup()
                                .addComponent(lblFullName3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtFullName3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel5CodeLayout.createSequentialGroup()
                                .addComponent(lblCurrentSquat)
                                .addGap(18, 18, 18)
                                .addComponent(txtCurrentSquat, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, Short.MAX_VALUE)
                        .addGroup(panel5CodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel5CodeLayout.createSequentialGroup()
                                .addComponent(lblCurrentPushup)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCurrentPushup, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel5CodeLayout.createSequentialGroup()
                                .addComponent(lblCurrentPlank)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCurrentPlank, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(buttonProgress))
                            .addGroup(panel5CodeLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(lblCurrentTreadmill)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCurrentTread, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel5CodeLayout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(lblErrorsFeed, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panel5CodeLayout.createSequentialGroup()
                        .addGroup(panel5CodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel5CodeLayout.createSequentialGroup()
                                .addGap(272, 272, 272)
                                .addComponent(programTitle5))
                            .addGroup(panel5CodeLayout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(panel5CodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panel5CodeLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(lblInstructions11))
                                    .addComponent(lblInstructions10))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(panel5CodeLayout.createSequentialGroup()
                .addGroup(panel5CodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel5CodeLayout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel5CodeLayout.createSequentialGroup()
                        .addGap(304, 304, 304)
                        .addComponent(lblHistoryReminder)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panel5CodeLayout.setVerticalGroup(
            panel5CodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel5CodeLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(programTitle5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblInstructions10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblInstructions11)
                .addGap(29, 29, 29)
                .addGroup(panel5CodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFullName3)
                    .addComponent(txtFullName3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCurrentPlank)
                    .addComponent(txtCurrentPlank, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonProgress))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel5CodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCurrentWeight)
                    .addComponent(txtCurrentWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCurrentPushup)
                    .addComponent(txtCurrentPushup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel5CodeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCurrentSquat)
                    .addComponent(txtCurrentSquat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCurrentTreadmill)
                    .addComponent(txtCurrentTread, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblErrorsFeed)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblHistoryReminder)
                .addContainerGap(203, Short.MAX_VALUE))
        );

        tabbedPane1.addTab("tab5", panel5Code);

        getContentPane().add(tabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, -30, 820, 620));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtWaterIntakeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtWaterIntakeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtWaterIntakeActionPerformed

    private void buttonCreateClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCreateClientActionPerformed
        // TODO add your handling code here:
        getInputs(clientArray);
        

    }//GEN-LAST:event_buttonCreateClientActionPerformed

    private void buttonWorkoutPlanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonWorkoutPlanActionPerformed
        // TODO add your handling code here:
        fitnessPlan(clientArray, client);
        
    }//GEN-LAST:event_buttonWorkoutPlanActionPerformed

    private void buttonProgressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonProgressActionPerformed
        // TODO add your handling code here:
        progressTracker(clientArray);
    }//GEN-LAST:event_buttonProgressActionPerformed

    private void buttonNextPage1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNextPage1ActionPerformed
        // TODO add your handling code here:
        tabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_buttonNextPage1ActionPerformed

    private void buttonNextPage2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNextPage2ActionPerformed
        // TODO add your handling code here:
        tabbedPane1.setSelectedIndex(3);
    }//GEN-LAST:event_buttonNextPage2ActionPerformed

    private void btnGenerateMealPlanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateMealPlanActionPerformed
        // conditional to ensure the user created a portfolio
        if (this.client == null) {
            //display error panel message if client information not found
            JOptionPane.showMessageDialog(this, "Client information not available. ");
            return;
        }
        //get user's input for number of meal sets
        String mealSetsInput = txtMealSetInput.getText();
        double calculatedCalories = client.calculateCalories();
        DecimalFormat df = new DecimalFormat("0.00");
        String formattedCalories = df.format(calculatedCalories);
        txtCalorieIntake.setText(formattedCalories);
        txtDietaryPreference.setText(client.getDietPreferences());
        //check if input is empty
        if (mealSetsInput.isEmpty()) {
            //print error message to user if empty
            txtMessage.setText("Please enter a number for meal sets. Try again!");
            return;
        }

        try {
            //convert the inpu to an integer
            int mealSets = Integer.parseInt(mealSetsInput);
            //check if teh input is within the valid ranege (1 to 7)
            if (mealSets >= 1 && mealSets <= 7) {
                //check if client information is available
                if (client != null) {
                    //create a mealplan object with client information and generate meal plan
                    MealPlan mealPlan = new MealPlan(client, "Recipe.txt", mealSets);
                    String generatedMeals = mealPlan.toString();
                    //display generated meal plan in text area
                    txtMealPlanArea.setText(generatedMeals);
                    //generate and display motivational message based on meal sets
                    String motivationalMessage = mealPlan.generateMotivationalMessage(mealSets);
                    txtMessage.setText(motivationalMessage);
                }
            } else {
                //if number is not between 1 to 7 it displays error message to user
                txtMessage.setText("Please enter a number between 1 and 7 for meal sets. Try again!");
                return;
            }
        } catch (NumberFormatException ex) {
            //catches and handles exception if user enters invalid input and displays error
            txtMessage.setText("Invalid Input. Please enter a valid number. Try again!");
            return;
        } catch (NullPointerException nfe) {
            txtMessage.setText("A Client was not even created. Try again.");
            return;
        }
        btnGenerateMealPlan.setEnabled(false);
    }//GEN-LAST:event_btnGenerateMealPlanActionPerformed

    private void buttonWaterSleepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonWaterSleepActionPerformed
        // TODO add your handling code here:
        waterTracker(client);
        
    }//GEN-LAST:event_buttonWaterSleepActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        tabbedPane1.setSelectedIndex(1);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void buttonExistingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExistingActionPerformed
        // TODO add your handling code here:
        tabbedPane1.setSelectedIndex(5);
    }//GEN-LAST:event_buttonExistingActionPerformed

    private void buttonNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNewActionPerformed
        // TODO add your handling code here:
         tabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_buttonNewActionPerformed

    private void buttonNextPage3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNextPage3ActionPerformed
        // TODO add your handling code here:
        tabbedPane1.setSelectedIndex(4);
    }//GEN-LAST:event_buttonNextPage3ActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_exitButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainClass().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerateMealPlan;
    private javax.swing.JRadioButton buttonAddictionNo;
    private javax.swing.JRadioButton buttonAddictionYes;
    private javax.swing.JButton buttonCreateClient;
    private javax.swing.JButton buttonExisting;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JRadioButton buttonMedYes;
    private javax.swing.JButton buttonNew;
    private javax.swing.JButton buttonNextPage1;
    private javax.swing.JButton buttonNextPage2;
    private javax.swing.JButton buttonNextPage3;
    private javax.swing.JRadioButton buttonNoMed;
    private javax.swing.JRadioButton buttonPregNo;
    private javax.swing.JRadioButton buttonPregYes;
    private javax.swing.JButton buttonProgress;
    private javax.swing.JButton buttonWaterSleep;
    private javax.swing.JButton buttonWorkoutPlan;
    private javax.swing.JTextArea congratsMessage;
    private javax.swing.JComboBox<String> dietComboBox;
    private javax.swing.JButton exitButton;
    private javax.swing.JTextArea feedbackBox;
    private javax.swing.JLabel instructionLbl1;
    private javax.swing.JLabel instructionLbl2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JLabel lblAddictions;
    private javax.swing.JLabel lblAge;
    private javax.swing.JLabel lblAvgSleep;
    private javax.swing.JLabel lblCurrentPlank;
    private javax.swing.JLabel lblCurrentPushup;
    private javax.swing.JLabel lblCurrentSquat;
    private javax.swing.JLabel lblCurrentTreadmill;
    private javax.swing.JLabel lblCurrentWeight;
    private javax.swing.JLabel lblDietPreference;
    private javax.swing.JLabel lblErr;
    private javax.swing.JLabel lblErr1;
    private javax.swing.JLabel lblErrFeedback;
    private javax.swing.JLabel lblErrorsFeed;
    private javax.swing.JLabel lblExhaustingDay;
    private javax.swing.JLabel lblFeedback;
    private javax.swing.JLabel lblFeedbackErrors;
    private javax.swing.JLabel lblFullName;
    private javax.swing.JLabel lblFullName3;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblHeight;
    private javax.swing.JLabel lblHistoryReminder;
    private javax.swing.JLabel lblHobby;
    private javax.swing.JLabel lblInstructions;
    private javax.swing.JLabel lblInstructions10;
    private javax.swing.JLabel lblInstructions11;
    private javax.swing.JLabel lblInstructions2;
    private javax.swing.JLabel lblInstructions4;
    private javax.swing.JLabel lblInstructions5;
    private javax.swing.JLabel lblInstructions6;
    private javax.swing.JLabel lblInstructions7;
    private javax.swing.JLabel lblInstructions8;
    private javax.swing.JLabel lblInstructions9;
    private javax.swing.JLabel lblMedicalCondition;
    private javax.swing.JLabel lblPlankTime;
    private javax.swing.JLabel lblPortfolio;
    private javax.swing.JLabel lblPregnant;
    private javax.swing.JLabel lblPromptUser;
    private javax.swing.JLabel lblPushupCount;
    private javax.swing.JLabel lblRecommedn2;
    private javax.swing.JLabel lblRecommend;
    private javax.swing.JLabel lblSquatCount;
    private javax.swing.JLabel lblTargetWeight;
    private javax.swing.JLabel lblTreadmillTime;
    private javax.swing.JLabel lblTypesMedical;
    private javax.swing.JLabel lblWaterIntake;
    private javax.swing.JLabel lblWeight;
    private javax.swing.JLabel mainTitle1;
    private javax.swing.JLabel mainTitle2;
    private javax.swing.JPanel panel0Code;
    private javax.swing.JPanel panel1Code;
    private javax.swing.JPanel panel2Code;
    private javax.swing.JPanel panel3Code;
    private javax.swing.JPanel panel5Code;
    private javax.swing.JTextArea printScreen;
    private javax.swing.JTextArea printScreen1;
    private javax.swing.JTextArea printScreenPlan;
    private javax.swing.JLabel programTitle2;
    private javax.swing.JLabel programTitle3;
    private javax.swing.JLabel programTitle4;
    private javax.swing.JLabel programTitle5;
    private javax.swing.JLabel subTitle1;
    private javax.swing.JLabel tabTitle1;
    private javax.swing.JTabbedPane tabbedPane1;
    private javax.swing.JTextField txtAgeNum;
    private javax.swing.JTextField txtAvgSleep;
    private javax.swing.JTextField txtCalorieIntake;
    private javax.swing.JTextField txtCurrentPlank;
    private javax.swing.JTextField txtCurrentPushup;
    private javax.swing.JTextField txtCurrentSquat;
    private javax.swing.JTextField txtCurrentTread;
    private javax.swing.JTextField txtCurrentWeight;
    private javax.swing.JTextField txtDietaryPreference;
    private javax.swing.JTextField txtExhaustingDay;
    private javax.swing.JTextField txtFullName;
    private javax.swing.JTextField txtFullName2;
    private javax.swing.JTextField txtFullName3;
    private javax.swing.JTextField txtGender;
    private javax.swing.JTextField txtHeightCm;
    private javax.swing.JTextField txtHobby;
    private javax.swing.JTextField txtInitalTreadmill;
    private javax.swing.JTextField txtInitialPlank;
    private javax.swing.JTextField txtInitialPushup;
    private javax.swing.JTextField txtInitialSquat;
    private javax.swing.JTextArea txtMealPlanArea;
    private javax.swing.JTextField txtMealSetInput;
    private javax.swing.JTextField txtMedicalCondition;
    private javax.swing.JTextField txtMessage;
    private javax.swing.JTextField txtTargetWeight;
    private javax.swing.JTextArea txtWaterFeedback;
    private javax.swing.JTextField txtWaterIntake;
    private javax.swing.JTextField txtWeightLbs;
    // End of variables declaration//GEN-END:variables
}

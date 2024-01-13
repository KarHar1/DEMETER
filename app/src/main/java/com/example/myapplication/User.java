package com.example.myapplication;

import java.io.Serializable;

class User implements Serializable {
    private static final long serialVersionUID = 1L;

    int age, weight, height, daily_calories, exer, goal_weight, days;
    boolean gender;
    String name;

    public User() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public void setExerciseLevel(int exer) {
        this.exer = exer;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setGoal_weight(int goal_weight) {
        this.goal_weight = goal_weight;
    }

    public void calculateCalories() {
        double bmr;
        if (gender) {
            bmr = 66.47 + (13.75 * weight) + (5.003 * height) - (6.755 * age);
        } else {
            bmr = 655.1 + (9.563 * weight) + (1.850 * height) - (4.676 * age);
        }

        double activityLevelMultiplier;
        switch (exer) {
            case 1:
                activityLevelMultiplier = 1.2;
                break;
            case 2:
                activityLevelMultiplier = 1.375;
                break;
            case 3:
                activityLevelMultiplier = 1.55;
                break;
            case 4:
                activityLevelMultiplier = 1.725;
                break;
            case 5:
                activityLevelMultiplier = 1.9;
                break;
            default:
                throw new IllegalArgumentException("Invalid activity level choice.");
        }

        double maintenanceCalories = bmr * activityLevelMultiplier;
        double fatLossCalories = maintenanceCalories - 500; // Aim for a 500 calorie deficit per day for fat loss
        double extremeFatLossCalories = maintenanceCalories - 1000; // Aim for a 1000 calorie deficit per day for extreme fat loss

        // Set the daily calorie intake values
        daily_calories = (int) maintenanceCalories;
        // Assuming fat loss is the goal by default
        goal_weight = (int) fatLossCalories;
    }
}

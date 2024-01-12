package com.example.myapplication;

import java.io.Serializable;

class User implements Serializable {
    private static final long serialVersionUID = 1L;

    int gml;
    int age, weight, height, daily_calories, exer, goal_weight, days;
    Boolean gender;
    String name;

    public User() {
    }

    public void setGml(int gml) {
        this.gml = gml;
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

    public void setGender(Boolean gender) {
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

    double countBMT(int age, int weight, int height, boolean gender, int goal_weight) {
        double bmt;
        if (gender) {
            bmt = (10 * weight) + (6.25 * height) - (5 * age) + 5;
        } else {
            bmt = (10 * weight) + (6.25 * height) - (5 * age) - 161;
        }
        return bmt;
    }

    double countTDE(int exer ,double btm ) {
        double tde = 0;
        switch (exer) {
            case 1:
                tde = btm * 1.2;
                break;
            case 2:
                tde = btm * 1.375;
                break;
            case 3:
                tde = btm * 1.55;
                break;
            case 4:
                tde = btm * 1.725;
                break;
        }
        return tde;
    }


    double bmi(int w, int h) {
        return w / (h * h);
    }

}

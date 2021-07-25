package com.example.fitnessapp;

public class exercise {

    String level,ex_name,equipments;


    public exercise(String level, String ex_name, String equipments, int background) {
        this.level = level;
        this.ex_name = ex_name;
        this.equipments = equipments;

    }

    public exercise() {
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getEx_name() {
        return ex_name;
    }

    public void setEx_name(String ex_name) {
        this.ex_name = ex_name;
    }

    public String getEquipments() {
        return equipments;
    }

    public void setEquipments(String equipments) {
        this.equipments = equipments;
    }

}

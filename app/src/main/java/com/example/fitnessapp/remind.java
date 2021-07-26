package com.example.fitnessapp;
import java.time.LocalDateTime;

public class remind {
    String rem_name;
    String dt;

    public remind() {
    }

    public remind(String rem_name, String dt) {
        this.rem_name = rem_name;
        this.dt = dt;
    }

    public String getRem_name() {
        return rem_name;
    }

    public void setRem_name(String rem_name) {
        this.rem_name = rem_name;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }
}

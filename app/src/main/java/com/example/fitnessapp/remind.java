package com.example.fitnessapp;
import java.time.LocalDateTime;

public class remind {
    String rem_name;
    LocalDateTime dt;

    public remind() {
    }

    public remind(String rem_name, LocalDateTime dt) {
        this.rem_name = rem_name;
        this.dt = dt;
    }

    public String getRem_name() {
        return rem_name;
    }

    public void setRem_name(String rem_name) {
        this.rem_name = rem_name;
    }

    public LocalDateTime getDt() {
        return dt;
    }

    public void setDt(LocalDateTime dt) {
        this.dt = dt;
    }
}

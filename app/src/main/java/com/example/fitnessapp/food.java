package com.example.fitnessapp;

public class food {

    String name,type,contents;

    public food() {
    }

    public food(String name, String type, String contents) {
        this.name = name;
        this.type = type;
        this.contents = contents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
}

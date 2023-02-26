package com.example.HarvestAnalyticModule.models.view;

public class ObjectType {
    private String id;
    private String name;
    private float percentage;
    private int number;

    public ObjectType(String id, String name, int percentage, int number) {
        this.id = id;
        this.name = name;
        this.percentage = percentage;
        this.number = number;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void incrementNumber(){
        this.setNumber(this.getNumber() + 1);
    }
}

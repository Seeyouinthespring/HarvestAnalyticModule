package com.example.HarvestAnalyticModule.models.view;

public class Material {
    private int id;
    private String name;
    private int weight;
    private float percentage;
    private int number;

    public Material(int id, String name, int weight, float percentage, int number){
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.percentage = percentage;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
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

    public void addWeight(int weight){
        this.weight = this.weight + weight;
    }
}

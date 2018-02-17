package com.example.fujitsu.mojprojekat.activity.modeli;

/**
 * Created by Ljubisa on 31.01.2018..
 */

public class Meal {

    private int id;
    private String image;
    private String name;
    private String description;
    private String ingredients;
    private int calories;
    private double price;
    private Category category;

    public Meal() {

    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Meal(int id, String image, String name, String description, String ingredients, int calories, double price, Category category) {
        this.id=id;
        this.image = image;
        this.name = name;
        this.description = description;
        this.category = category;
        this.ingredients = ingredients;
        this.calories = calories;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Meal{" +
                "id=" + id +
                ", image='" + image + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", ingredients=" + ingredients + '\'' +
                ", calories=" + calories + '\'' +
                ", price=" + price + '\'' +
                '}';
    }
}

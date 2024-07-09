package com.example.pizza;

import java.util.UUID;

public class Ingredient extends EntityBase {

    private String name;
    private Double price;
    protected Ingredient(UUID id, String name, Double price) {
        super(id);        
        this.name = name;
        this.price = price;
    }

    public void update(String name,double price){
        //eventos
        this.name = name;
        this.price = price;
    }
    public String getName(){
        return name;
    }
    public Double getPrice(){
        return price;
    }
    public static Ingredient create(UUID id, String name, Double price){
        //eventos
        return new Ingredient(id, name, price);
    }

    @Override
    public String toString() {
        return "Ingredient [name=" + name + ", price=" + price + ", getId()=" + getId() + "]";
    }

    
}
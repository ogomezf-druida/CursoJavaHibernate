package com.example.liskov;

public abstract class Ave {
    private final int peso;

    public Ave(int peso) {
        this.peso = peso;
    }

    public int getPeso() {
        return peso;
    }

}
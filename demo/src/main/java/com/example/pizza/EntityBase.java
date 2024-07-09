package com.example.pizza;

import java.util.UUID;

public abstract class EntityBase {
    private UUID id; //atributos
    protected EntityBase(UUID id){ //constructor
        this.id = id;
    }
    public UUID getId(){   //getter
        return id;
    }
    @Override
    public int hashCode() {
       return id.hashCode();
    }
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof EntityBase e){
            return e.id.equals(this.id);
        }
        return false;
    }
}

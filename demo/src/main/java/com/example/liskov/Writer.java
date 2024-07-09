package com.example.liskov;

import java.util.function.Consumer;

public class Writer {
    public static void printAve(Ave ave, Consumer<Object> writer){
        writer.accept("Aves");
        writer.accept(ave.getPeso());
    }
    public static void printAvNoVoladora(AveNoVoladora ave,Consumer<Object> writer){
        writer.accept("Aves no voladora");
        writer.accept(ave.getPeso());
    }
    public static void printAvVoladora(AveVoladora ave, Consumer<Object> writer){
        writer.accept("Aves voladora");
        writer.accept(ave.getPeso());
        writer.accept(ave.getVelocidad());
    }
}

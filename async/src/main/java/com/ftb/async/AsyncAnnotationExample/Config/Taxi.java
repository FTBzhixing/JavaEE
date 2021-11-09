package com.ftb.async.AsyncAnnotationExample.Config;

import org.springframework.beans.factory.annotation.Autowired;

public class Taxi {
    @Autowired
    private Car car;

    public static void main(String[] args) {
        Taxi taxi = new Taxi();
        System.out.println(taxi.car.name);
    }
}

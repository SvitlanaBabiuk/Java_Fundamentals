package com.softserve.edu06.hw.bird;

public class Eagle extends FlyingBird {

    //some fields

    @Override
    public void fly() {
        super.fly();
        System.out.println("It's eagle");
    }

}

package com.softserve.academy.edu06.hw.task_1;

public class FlyingBird extends Bird
{
    public FlyingBird(boolean feathers, boolean layEggs) {
        super(feathers, layEggs);
    }

    @Override
    public void fly() {
        System.out.println("Flying bird is flying");
    }
}

package com.example.springbootdocker.aop.ex1;

public class Robot implements Singable {
    @Override
    public void sing() {
        System.out.println("Robot is singing !");
    }
}

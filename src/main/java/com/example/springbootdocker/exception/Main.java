package com.example.springbootdocker.exception;

public class Main {
    final int MAX_QUANTITY = 2;

    public void addQuantity(int quantity) throws OverLimitQuantityException {
        if (quantity > MAX_QUANTITY) throw new OverLimitQuantityException("Over limit!");
        System.out.println("Oke success");
    }

    public static void main(String[] args) {
        Main main = new Main();
        try {
            main.addQuantity(2);
            main.addQuantity(3);
        } catch (OverLimitQuantityException e) {
            System.out.println(e.getMessage());
        }
    }
}

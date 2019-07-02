package com.radek.store.exception;

public class OrderNotFoundException extends RuntimeException {

    public OrderNotFoundException() {
        super("Nie ma takiego zamówienia");
    }

}

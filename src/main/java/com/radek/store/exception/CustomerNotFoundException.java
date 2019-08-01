package com.radek.store.exception;

public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException() {
        super("Nie ma tekiego klienta");
    }
}

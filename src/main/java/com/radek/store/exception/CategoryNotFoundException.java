package com.radek.store.exception;

public class CategoryNotFoundException extends RuntimeException {

    public CategoryNotFoundException() {
        super("No such category");
    }
}

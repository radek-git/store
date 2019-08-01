package com.radek.store.exception;

public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException() {
        super("Nie ma tekiego pracownika");
    }
}

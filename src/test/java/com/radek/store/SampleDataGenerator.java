package com.radek.store;

import com.radek.store.entity.Brand;
import com.radek.store.entity.Category;
import com.radek.store.entity.Position;
import com.radek.store.entity.Store;
import com.radek.store.entity.users.Customer;
import com.radek.store.entity.users.Employee;

import java.util.HashSet;

public class SampleDataGenerator {

    public static Customer getCustomer() {
        return new Customer("Jan", "Nowak", "jnowak", "jan@nowak.pl", "dupa",
                "4444444444", "Warsaw", "Duza", "01-105", null);
    }



    public static Store getEmptyStore() {
        return new Store("Store1", "1111111", new HashSet<>(), new HashSet<>());
    }


    public static Position getEmployeePosition() {
        return new Position("clerk");
    }

    public static Employee getEmployee1(Store store, Position position) {
        return new Employee("Anna", "Guma", "aguma", "anna@guma.pl", "dupa",
                "55555555", store, position, getManager(store) );
    }

    public static Employee getEmployee2(Store store, Position position) {
        return new Employee("Jan", "Ryba", "aguma", "anna@guma.pl", "dupa",
                "555545555", store, position, getManager(store) );
    }



    public static Employee getManager(Store store) {
        return new Employee("Pawel", "Dym", "pdym", "pawel@guma.pl", "dupa",
                "333355555", store, getManagerPosition(), null);
    }


    public static Position getManagerPosition() {
        return new Position("manager");
    }

    public static Category getCategory() {
        return new Category("computers");
    }

    public static Brand getBrand() {
        return new Brand("computers");
    }




}

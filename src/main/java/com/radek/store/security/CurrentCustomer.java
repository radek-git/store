package com.radek.store.security;

import com.radek.store.entity.users.Customer;
import org.springframework.security.access.prepost.PreAuthorize;

public interface CurrentCustomer {

    @PreAuthorize("isAuthenticated()")
    Customer getCustomer();
}

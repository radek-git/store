package com.radek.store.security;

import com.radek.store.entity.users.Employee;
import org.springframework.security.access.prepost.PreAuthorize;

public interface CurrentEmployee {

    @PreAuthorize("isAuthenticated()")
    Employee getEmployee();
}

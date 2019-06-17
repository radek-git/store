package com.radek.store.security;

import com.radek.store.entity.users.User;
import org.springframework.security.access.prepost.PreAuthorize;

public interface CurrentUser {

    @PreAuthorize("isAuthenticated()")
    User getUser();
}

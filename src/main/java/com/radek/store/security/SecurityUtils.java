package com.radek.store.security;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class SecurityUtils {

    public SecurityUtils() {
    }


    public static String getUsername() {
        SecurityContext context = SecurityContextHolder.getContext();

        if (isUserLoggedIn()) {
            Object principal = context.getAuthentication().getPrincipal();

            if (principal instanceof UserDetails) {
                UserDetails userDetails = (UserDetails) context.getAuthentication().getPrincipal();
                return userDetails.getUsername();
            }
        }

        return null;
    }

    public static boolean isUserLoggedIn () {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication != null && !(authentication instanceof AnonymousAuthenticationToken);
    }



}

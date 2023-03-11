package com.example.PortfolioApplication.controllers;

import com.example.PortfolioApplication.entities.ApplicationUser;
import com.example.PortfolioApplication.services.ApplicationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ApplicationUserController {
    @Autowired
    ApplicationUserService applicationUserService;
    @GetMapping("/applicationUsers/{id}")
    public ApplicationUser show(@PathVariable Long id) {
        return applicationUserService.getApplicationUser(id);
    }

    @PostMapping("/applicationUsers")
    public ApplicationUser create(final @RequestBody ApplicationUser applicationUser) {
        return applicationUserService.createApplicationUser(applicationUser);
    }
}

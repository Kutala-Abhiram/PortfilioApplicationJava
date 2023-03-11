package com.example.PortfolioApplication.services;

import com.example.PortfolioApplication.entities.ApplicationUser;
import com.example.PortfolioApplication.repositories.ApplicationUserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserService {
    @Autowired
    ApplicationUserRepository applicationUserRepository;
    public ApplicationUser getApplicationUser(Long userId) {
        return applicationUserRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found"));
    }

    public ApplicationUser createApplicationUser(ApplicationUser applicationUser) {
        return applicationUserRepository.save(applicationUser);
    }
}

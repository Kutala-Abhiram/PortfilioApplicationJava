package com.example.PortfolioApplication.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.Set;

@Entity
@Data
@Table(name="portfolio")
public class Portfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @NotBlank
    private String name;
    @Column(columnDefinition = "bool default false")
    private boolean holdingsPortfolio;
    @ManyToOne
    @JoinColumn(name = "application_user_id")
    private ApplicationUser applicationUser;
    @ManyToMany
    @JoinTable(
            name="portfolio_scripts",
            joinColumns = @JoinColumn(name = "portfolio_id"),
            inverseJoinColumns = @JoinColumn(name = "script_id")
    )
    Set<Script> portfolioScripts;
}

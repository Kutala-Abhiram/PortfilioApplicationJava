package com.example.PortfolioApplication.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
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
    @OneToMany(mappedBy = "portfolio")
    private List<PortfolioScripts> portfolioScripts = new ArrayList<>();
}

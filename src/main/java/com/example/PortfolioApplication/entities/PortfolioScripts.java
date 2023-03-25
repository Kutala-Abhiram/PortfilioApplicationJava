package com.example.PortfolioApplication.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="portfolio_scripts")
public class PortfolioScripts {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "script_id")
    Script script;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "portfolio_id")
    Portfolio portfolio;
}

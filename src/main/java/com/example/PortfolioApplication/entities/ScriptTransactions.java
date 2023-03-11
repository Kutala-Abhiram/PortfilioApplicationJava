package com.example.PortfolioApplication.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name="script_transactions")
public class ScriptTransactions {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @ManyToOne
    @JoinColumn(name = "script_id")
    Script script;
    @ManyToOne
    @JoinColumn(name = "application_user_id")
    ApplicationUser applicationUser;
    @NotNull
    @Min(value = 1L, message = "Quantity Must be positive")
    private long quantity;
    @NotNull
    @Min(value = 0L, message = "Price must be positive")
    private float price;
    @NotNull
    private Date transationDate;
}

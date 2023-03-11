package com.example.PortfolioApplication.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name="script")
public class Script {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @NotBlank
    private String name;
    private String nseCode;
    private String bseCode;
    private float lastTradedPrice;
    @Min(value = 1)
    @Max(value = 2)
    private int market;
    @OneToMany(mappedBy = "script")
    List<ScriptTransactions> transactions;
    @OneToMany(mappedBy = "script")
    List<ScriptNotes> notes;
}


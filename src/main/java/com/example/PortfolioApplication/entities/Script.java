package com.example.PortfolioApplication.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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
@Table(name="script", uniqueConstraints = {@UniqueConstraint(columnNames = {"nseCode", "bseCode"})})
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
    @JsonIgnore
    List<ScriptTransactions> transactions = new ArrayList<>();
    @OneToMany(mappedBy = "script", fetch = FetchType.LAZY)
    @JsonIgnore
    List<ScriptNotes> note = new ArrayList<>();;
    @OneToMany(mappedBy = "script", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<PortfolioScripts> portfolioScripts = new ArrayList<>();
}


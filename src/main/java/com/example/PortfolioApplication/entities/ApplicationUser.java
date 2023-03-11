package com.example.PortfolioApplication.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name="ApplicationUser")
public class ApplicationUser {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @NotBlank
    private String name;
    @Email
    @NotNull
    private String email;
    private String mobile;
    @OneToMany(mappedBy = "applicationUser")
    List<ScriptTransactions> transactions;
    @OneToMany(mappedBy = "applicationUser")
    List<ScriptNotes> notes;
}

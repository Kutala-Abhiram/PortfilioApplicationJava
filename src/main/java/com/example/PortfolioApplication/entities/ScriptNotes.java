package com.example.PortfolioApplication.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "script_notes")
public class ScriptNotes {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotBlank
    private String notes;
    @Column(columnDefinition = "timestamp default current_timestamp")
    private Date createdAt;
    @NotBlank
    @Min(value = 0, message = "Priority should be atleast 0")
    @Max(value = 8, message = "Priority can not be greater than 8")
    @Column(columnDefinition = "integer default 5")
    private int priority;
    @Column(columnDefinition = "bool default false")
    private boolean confidential;
    @ManyToOne
    @JoinColumn(name = "script_id")
    Script script;
    @ManyToOne
    @JoinColumn(name = "application_user_id")
    ApplicationUser applicationUser;
}

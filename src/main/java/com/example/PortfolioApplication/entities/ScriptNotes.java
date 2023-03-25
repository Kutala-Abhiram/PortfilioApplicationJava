package com.example.PortfolioApplication.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "script_notes")
public class ScriptNotes {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotBlank
    private String title;
    @NotBlank
    private String notes;
    @Column(columnDefinition = "timestamp default current_timestamp")
    private Date createdAt;
    private List<String> tags;
    @Min(value = 0, message = "Priority should be atleast 0")
    @Max(value = 8, message = "Priority can not be greater than 8")
    @Column(columnDefinition = "integer default 5")
    private int priority;
    @Column(columnDefinition = "bool default false")
    private boolean confidential;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "script_id")
    Script script;
    @ManyToOne
    @JoinColumn(name = "application_user_id")
    ApplicationUser applicationUser;
}

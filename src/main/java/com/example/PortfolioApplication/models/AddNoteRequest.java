package com.example.PortfolioApplication.models;

import lombok.Data;

import java.util.List;

@Data
public class AddNoteRequest {
    private String title;
    private String notes;
    private int priority;
    private List<String> tags;
    private Long scriptId;
}

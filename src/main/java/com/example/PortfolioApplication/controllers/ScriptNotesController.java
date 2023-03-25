package com.example.PortfolioApplication.controllers;

import com.example.PortfolioApplication.entities.ScriptNotes;
import com.example.PortfolioApplication.models.AddNoteRequest;
import com.example.PortfolioApplication.services.ScriptNotesService;
import com.example.PortfolioApplication.services.ScriptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ScriptNotesController {
    @Autowired
    ScriptNotesService scriptNotesService;
    @PostMapping("/notes")
    public ScriptNotes createScriptNotes(final @RequestBody AddNoteRequest addNoteRequest) {
        return scriptNotesService.createScriptNotes(addNoteRequest);
    }

    @GetMapping("/scripts/{scriptId}/notes")
    public List<ScriptNotes> getScriptNotes(@PathVariable Long scriptId) {
        return scriptNotesService.getScriptNotes(scriptId);
    }
}

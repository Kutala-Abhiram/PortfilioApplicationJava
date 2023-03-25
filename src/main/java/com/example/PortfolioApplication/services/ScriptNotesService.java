package com.example.PortfolioApplication.services;

import com.example.PortfolioApplication.entities.Script;
import com.example.PortfolioApplication.entities.ScriptNotes;
import com.example.PortfolioApplication.models.AddNoteRequest;
import com.example.PortfolioApplication.repositories.ScriptNotesRepository;
import com.example.PortfolioApplication.repositories.ScriptRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@Service
public class ScriptNotesService {
    @Autowired
    ScriptNotesRepository scriptNotesRepository;
    @Autowired
    ScriptRepository scriptRepository;
    public ScriptNotes createScriptNotes(AddNoteRequest scriptNotes) {
        Script script = scriptRepository.findById(scriptNotes.getScriptId())
                .orElseThrow(() -> new EntityNotFoundException("Script Not Found"));
        return scriptNotesRepository.save(ScriptNotes.builder()
                        .title(scriptNotes.getTitle())
                        .notes(scriptNotes.getNotes())
                        .priority(scriptNotes.getPriority())
                        .tags(scriptNotes.getTags())
                        .createdAt(Date.from(Instant.now()))
                        .script(script)
                        .build()
        );
    }

    public List<ScriptNotes> getScriptNotes(Long scripId) {
        Script script = scriptRepository.findById(scripId)
                .orElseThrow(() -> new EntityNotFoundException("Script Not Found"));
        return scriptNotesRepository.findAllByScript(script);
    }
}

package com.example.PortfolioApplication.services;

import com.example.PortfolioApplication.entities.Script;
import com.example.PortfolioApplication.repositories.ScriptRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScriptService {
    @Autowired
    ScriptRepository scriptRepository;
    public Script createScript(Script script) {
        return scriptRepository.save(script);
    }

    public List<Script> getScripts() {
        return scriptRepository.findAll();
    }

    public Script getScript(final Long id) {
        return scriptRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Script not found"));
    }
}

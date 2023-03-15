package com.example.PortfolioApplication.services;

import com.example.PortfolioApplication.entities.Script;
import com.example.PortfolioApplication.repositories.ScriptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScriptService {
    @Autowired
    ScriptRepository scriptRepository;
    public Script createScript(Script script) {
        return scriptRepository.save(script);
    }
}

package com.example.PortfolioApplication.controllers;

import com.example.PortfolioApplication.entities.Script;
import com.example.PortfolioApplication.services.ScriptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ScriptsController {
    @Autowired
    ScriptService scriptService;
    @PostMapping("/scripts")
    public Script createScript(final @RequestBody Script script) {
        return scriptService.createScript(script);
    }
}

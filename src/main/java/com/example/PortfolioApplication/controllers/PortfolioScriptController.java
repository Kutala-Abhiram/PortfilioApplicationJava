package com.example.PortfolioApplication.controllers;

import com.example.PortfolioApplication.entities.Portfolio;
import com.example.PortfolioApplication.entities.Script;
import com.example.PortfolioApplication.models.AddScriptRequest;
import com.example.PortfolioApplication.services.PortfolioScriptService.PortfolioScriptInterface;
import com.example.PortfolioApplication.services.PortfolioService;
import com.example.PortfolioApplication.services.ScriptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class PortfolioScriptController {
    @Autowired
    PortfolioScriptInterface portfolioScriptInterface;
    @Autowired
    PortfolioService portfolioService;
    @Autowired
    ScriptService scriptService;
    @PostMapping("/portfolio/{id}/scripts")
    public Portfolio addScript(final @PathVariable Long id, final @RequestBody AddScriptRequest requestBody) {
        return portfolioScriptInterface.addScript(
                portfolioService.getPortfolio(id),
                scriptService.getScript(requestBody.getScriptId())
        );
    }

    @GetMapping("/portfolio/{id}/scripts")
    public List<Script> getPortfolioScripts(final @PathVariable Long id) {
        return portfolioScriptInterface.getPortfolioScripts(id);
    }
}

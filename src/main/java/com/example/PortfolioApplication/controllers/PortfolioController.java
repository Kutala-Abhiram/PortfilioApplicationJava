package com.example.PortfolioApplication.controllers;

import com.example.PortfolioApplication.entities.Portfolio;
import com.example.PortfolioApplication.entities.Script;
import com.example.PortfolioApplication.models.AddScriptRequest;
import com.example.PortfolioApplication.services.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class PortfolioController {
    @Autowired
    PortfolioService portfolioService;

    @PostMapping("/portfolio")
    public Portfolio createPortfolio(final @RequestBody Portfolio portfolio) {
        return portfolioService.createPortfolio(portfolio);
    }

    @GetMapping("/portfolio")
    public List<Portfolio> getPortfolios() {
        return portfolioService.getPortfolios();
    }

    @GetMapping("/portfolio/{id}")
    public Portfolio getPortfolio(final @PathVariable Long id) {
        return portfolioService.getPortfolio(id);
    }
}

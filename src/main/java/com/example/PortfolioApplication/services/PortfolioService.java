package com.example.PortfolioApplication.services;

import com.example.PortfolioApplication.entities.Portfolio;
import com.example.PortfolioApplication.entities.Script;
import com.example.PortfolioApplication.repositories.PortfolioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PortfolioService {
    @Autowired
    PortfolioRepository portfolioRepository;
    @Autowired
    ScriptService scriptService;
    public Portfolio createPortfolio(Portfolio portfolio) {
        portfolio.setPortfolioScripts(new HashSet<>());
        return portfolioRepository.save(portfolio);
    }

    public List<Portfolio> getPortfolios() {
        return portfolioRepository.findAll();
    }

    public Portfolio getPortfolio(long portfolioId) {
        return portfolioRepository.findById(portfolioId)
                .orElseThrow(() -> new EntityNotFoundException("Portfolio not found"));
    }

    public Portfolio addScript(Long portfolioId, long scriptId) {
        Portfolio portfolio = getPortfolio(portfolioId);
        Set<Script> portfolioScripts = portfolio.getPortfolioScripts();
        portfolioScripts.add(scriptService.getScript(scriptId));
        portfolio.setPortfolioScripts(portfolioScripts);
        return portfolioRepository.save(portfolio);
    }
}

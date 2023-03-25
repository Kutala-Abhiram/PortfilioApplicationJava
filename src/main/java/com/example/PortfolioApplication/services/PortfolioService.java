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
        return portfolioRepository.save(portfolio);
    }

    public List<Portfolio> getPortfolios() {
        return portfolioRepository.findAll();
    }

    public Portfolio getPortfolio(long portfolioId) {
        return portfolioRepository.findById(portfolioId)
                .orElseThrow(() -> new EntityNotFoundException("Portfolio not found"));
    }
}

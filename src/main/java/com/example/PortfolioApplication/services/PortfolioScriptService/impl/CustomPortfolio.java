package com.example.PortfolioApplication.services.PortfolioScriptService.impl;

import com.example.PortfolioApplication.entities.Portfolio;
import com.example.PortfolioApplication.entities.PortfolioScripts;
import com.example.PortfolioApplication.entities.Script;
import com.example.PortfolioApplication.repositories.PortfolioRepository;
import com.example.PortfolioApplication.repositories.PortfolioScriptRepository;
import com.example.PortfolioApplication.services.PortfolioScriptService.PortfolioScriptInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Primary
@Slf4j
public class CustomPortfolio implements PortfolioScriptInterface {
    @Autowired
    PortfolioScriptRepository portfolioScriptRepository;
    @Autowired
    PortfolioRepository portfolioRepository;
    @Override
    public Portfolio addScript(Portfolio portfolio, Script script) {

        return portfolioScriptRepository.save(PortfolioScripts.builder()
                .portfolio(portfolio)
                .script(script)
                .build()
        ).getPortfolio();
    }

    @Override
    public List<Script> getPortfolioScripts(Long portfolioId) {
        Portfolio portfolio = portfolioRepository.findById(portfolioId)
                .orElseThrow(() -> new EntityNotFoundException("Portfolio Not Found"));
        List<PortfolioScripts> portfolioScripts = portfolioScriptRepository.findAllByPortfolio(portfolio);
        List<Script> scripts = new ArrayList<>();
        for (PortfolioScripts portfolioScript: portfolioScripts) {
            scripts.add(portfolioScript.getScript());
        }
        return scripts;
    }
}

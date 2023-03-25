package com.example.PortfolioApplication.services.PortfolioScriptService;

import com.example.PortfolioApplication.entities.Portfolio;
import com.example.PortfolioApplication.entities.Script;

import java.util.List;
import java.util.Set;

public interface PortfolioScriptInterface {
    public Portfolio addScript(Portfolio portfolio, Script script);

    List<Script> getPortfolioScripts(Long portfolioId);

}

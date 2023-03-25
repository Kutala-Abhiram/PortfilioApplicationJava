package com.example.PortfolioApplication.repositories;

import com.example.PortfolioApplication.entities.Portfolio;
import com.example.PortfolioApplication.entities.PortfolioScripts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PortfolioScriptRepository extends JpaRepository<PortfolioScripts, Long> {
    List<PortfolioScripts> findAllByPortfolio(Portfolio portfolio);
}

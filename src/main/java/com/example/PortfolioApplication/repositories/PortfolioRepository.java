package com.example.PortfolioApplication.repositories;

import com.example.PortfolioApplication.entities.Portfolio;
import com.example.PortfolioApplication.entities.Script;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {
}

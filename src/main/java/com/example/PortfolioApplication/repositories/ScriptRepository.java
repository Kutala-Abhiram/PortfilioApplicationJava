package com.example.PortfolioApplication.repositories;

import com.example.PortfolioApplication.entities.Script;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScriptRepository extends JpaRepository<Script, Long> {
}

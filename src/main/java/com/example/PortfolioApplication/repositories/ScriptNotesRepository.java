package com.example.PortfolioApplication.repositories;

import com.example.PortfolioApplication.entities.Script;
import com.example.PortfolioApplication.entities.ScriptNotes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScriptNotesRepository extends JpaRepository<ScriptNotes, Long> {
    List<ScriptNotes> findAllByScript(Script script);
}

package com.SpringHotel.repository;

import com.SpringHotel.entity.Prenotazioni;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrenotazioniRepository extends JpaRepository<Prenotazioni, Integer> {
    public List<Prenotazioni> getPrenotazioniById(Integer id);
}
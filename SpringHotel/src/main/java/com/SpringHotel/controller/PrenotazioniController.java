package com.SpringHotel.controller;

import com.SpringHotel.entity.Prenotazioni;
import com.SpringHotel.entity.UtentePrenotazioni;
import com.SpringHotel.repository.UtentePrenotazioniRepository;
import com.SpringHotel.service.PrenotazioniService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api/prenotazioni")
public class PrenotazioniController {
    @Autowired
    PrenotazioniService prenotazioniS;
    @Autowired
    UtentePrenotazioniRepository utentePrenotazioniR;
    @PostMapping("/addUtentePrenotazioni")
    public UtentePrenotazioni addUtentePrenotazioni(@RequestBody UtentePrenotazioni up){
        return utentePrenotazioniR.save(up);
    }
    @GetMapping("/getById/{id}")
    public List<Prenotazioni> GetPrenotazioniById(@PathVariable Integer id){
        return prenotazioniS.GetPrenotazioniById(id);
    }
    @GetMapping("/getAll")
    public List<Prenotazioni> GetAllprenotazioni(){

        return prenotazioniS.GetAll();
    }
    @PostMapping("/add")
    public Prenotazioni addprenotazioni(@RequestBody Prenotazioni u){

        return prenotazioniS.addPrenotazioni(u);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteprenotazioni(@PathVariable Integer id,Prenotazioni u){
        return prenotazioniS.deleteByPrenotazioniId(id);
    }
    @PutMapping("/update/{id}")
    public Prenotazioni updateprenotazioni(@PathVariable Integer id,@RequestBody Prenotazioni u){
        return prenotazioniS.updatePrenotazioni(id,u);
    }
}


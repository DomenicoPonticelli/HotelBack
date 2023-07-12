package com.SpringHotel.service;

import com.SpringHotel.entity.Prenotazioni;
import com.SpringHotel.repository.PrenotazioniRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrenotazioniService {
    @Autowired
    PrenotazioniRepository PrenotazioniR;

    public List<Prenotazioni> GetAll(){
        return PrenotazioniR.findAll();
    }
    public List<Prenotazioni> GetPrenotazioniById(Integer id){ return PrenotazioniR.getPrenotazioniById(id);}
    public Prenotazioni addPrenotazioni(Prenotazioni u){
        Prenotazioni p = PrenotazioniR.findById(u.getId()).orElse(null);
        if(p!=null) {
            return PrenotazioniR.save(u);
        }else {
            return null;
             }
        }
    public String deleteByPrenotazioniId(Integer id){
        PrenotazioniR.deleteById(id);
        return "Prenotazioni Eliminato!";
    }
    public Prenotazioni updatePrenotazioni(Integer id,Prenotazioni u){
        Prenotazioni utente= PrenotazioniR.findById(id).orElse(null);
        if(utente!=null){
            return PrenotazioniR.save(u);
        }
        else {
            return null;
        }
    }
}
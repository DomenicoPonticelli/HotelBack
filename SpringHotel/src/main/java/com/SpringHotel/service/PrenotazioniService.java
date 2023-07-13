package com.SpringHotel.service;

import com.SpringHotel.entity.Prenotazioni;
import com.SpringHotel.entity.TipoStanza;
import com.SpringHotel.entity.UtentePrenotazioni;
import com.SpringHotel.repository.PrenotazioniRepository;
import com.SpringHotel.repository.TipoStanzaRepository;
import com.SpringHotel.repository.UtentePrenotazioniRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PrenotazioniService {
    @Autowired
    PrenotazioniRepository prenotazioniR;
    @Autowired
    TipoStanzaRepository tipoStanzaR;
    public List<Object> getPrenotazioniAndUserId(){
        return prenotazioniR.getPrenotazioniAndUserId();
    }
    public List<Prenotazioni> getPrenotazioniByIdStanza(Integer idStanza) {
        return prenotazioniR.getPrenotazioniByIdStanza(idStanza);
    }

    public List<Prenotazioni> GetAll() {
        return prenotazioniR.findAll();
    }

    public List<Prenotazioni> GetPrenotazioniById(Integer id) {
        return prenotazioniR.getPrenotazioniById(id);
    }

    public Prenotazioni addPrenotazioni(Prenotazioni u) {
        ArrayList<Prenotazioni> prenotazioni = (ArrayList<Prenotazioni>) prenotazioniR.findAll();
        TipoStanza stanza = tipoStanzaR.findById(u.getIdTipoStanza().getId()).orElse(null);
        LocalDate dataInizio = u.getDataInizio();
        LocalDate dataFine = u.getDataFine();
        for (int i = 0; i < prenotazioni.toArray().length; i++) {
            System.out.println(prenotazioni.get(i).getDataFine());
            System.out.println(prenotazioni.get(i).getDataInizio());
            System.out.println(dataFine);
            System.out.println(dataInizio);
            System.out.println(prenotazioni.get(i).getIdTipoStanza());
            System.out.println(u.getIdTipoStanza());
            if (prenotazioni.get(i).getIdTipoStanza().getId() == u.getIdTipoStanza().getId()) {
                System.out.println("controllo la stessa stanza");
                if (prenotazioni.get(i).getDataInizio().isEqual(dataInizio)) {
                    System.out.println("ho la stessa DataInizio");
                    return null;
                } else if (prenotazioni.get(i).getDataFine().isBefore(dataFine) || prenotazioni.get(i).getDataFine().isEqual(dataFine)) {
                    System.out.println("finisco quando c'è già una prenotazione");
                    return null;
                }
            }
        }
        return prenotazioniR.save(u);
    }
        public String deleteByPrenotazioniId (Integer id){
            prenotazioniR.deleteById(id);
            return "Prenotazioni Eliminato!";
        }
        public Prenotazioni updatePrenotazioni ( Prenotazioni u){
                return prenotazioniR.save(u);
        }
    }

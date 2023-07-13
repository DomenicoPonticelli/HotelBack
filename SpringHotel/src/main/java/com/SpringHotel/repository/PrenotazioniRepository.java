package com.SpringHotel.repository;

import com.SpringHotel.entity.Prenotazioni;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PrenotazioniRepository extends JpaRepository<Prenotazioni, Integer> {
    public List<Prenotazioni> getPrenotazioniById(Integer id);
    @Query(value = "Select * from springhotel.prenotazioni Join utente_prenotazioni on prenotazioni.id=utente_prenotazioni.id_prenotazioni Join users on users.id=utente_prenotazioni.id_utente Join tipo_stanza on tipo_stanza.id=prenotazioni.id_tipo_stanza",nativeQuery = true)
    public List<Object>getPrenotazioniAndUserId();
    @Query(value="SELECT prenotazioni.* FROM springhotel.prenotazioni Join tipo_stanza On prenotazioni.id_tipo_stanza=tipo_stanza.id WHERE prenotazioni.id_tipo_stanza=:idStanza",nativeQuery = true)
    public List<Prenotazioni>getPrenotazioniByIdStanza(Integer idStanza);
}
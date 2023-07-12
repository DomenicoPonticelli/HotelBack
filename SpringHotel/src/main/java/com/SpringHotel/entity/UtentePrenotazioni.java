package com.SpringHotel.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "utente_prenotazioni")
public class UtentePrenotazioni {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_prenotazioni", nullable = false)
    private Prenotazioni idPrenotazioni;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_utente", nullable = false)
    private User idUtente;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Prenotazioni getIdPrenotazioni() {
        return idPrenotazioni;
    }

    public void setIdPrenotazioni(Prenotazioni idPrenotazioni) {
        this.idPrenotazioni = idPrenotazioni;
    }

    public User getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(User idUtente) {
        this.idUtente = idUtente;
    }

}
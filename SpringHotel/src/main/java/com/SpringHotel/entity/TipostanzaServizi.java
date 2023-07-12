package com.SpringHotel.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "tipostanza_servizi")
public class TipostanzaServizi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_servizi", nullable = false)
    private Servizi idServizi;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_tipo_stanza", nullable = false)
    private TipoStanza idTipoStanza;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Servizi getIdServizi() {
        return idServizi;
    }

    public void setIdServizi(Servizi idServizi) {
        this.idServizi = idServizi;
    }

    public TipoStanza getIdTipoStanza() {
        return idTipoStanza;
    }

    public void setIdTipoStanza(TipoStanza idTipoStanza) {
        this.idTipoStanza = idTipoStanza;
    }

}
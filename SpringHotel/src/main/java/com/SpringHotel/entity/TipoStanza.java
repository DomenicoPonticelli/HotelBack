package com.SpringHotel.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tipo_stanza")
public class TipoStanza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "prezzo", nullable = false)
    private Double prezzo;

    @Column(name = "tipo", nullable = false)
    private String tipo;

    @Column(name = "n_posti", nullable = false)
    private Integer nPosti;

    @Column(name = "nome", nullable = false)
    private String nome;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(Double prezzo) {
        this.prezzo = prezzo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getNPosti() {
        return nPosti;
    }

    public void setNPosti(Integer nPosti) {
        this.nPosti = nPosti;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
package com.SpringHotel.service;

import com.SpringHotel.entity.TipoStanza;
import com.SpringHotel.repository.TipoStanzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoStanzaService {
    @Autowired
    TipoStanzaRepository TipoStanzaR;

    public List<TipoStanza> GetAll(){
        return TipoStanzaR.findAll();
    }
    public TipoStanza addTipoStanza(TipoStanza u){
        return TipoStanzaR.save(u);
    }
    public String deleteByTipoStanzaId(Integer id){
        TipoStanzaR.deleteById(id);
        return "TipoStanza Eliminato!";
    }
    public TipoStanza updateTipoStanza(Integer id,TipoStanza u){
        TipoStanza utente= TipoStanzaR.findById(id).orElse(null);
        if(utente!=null){
            return TipoStanzaR.save(u);
        }
        else {
            return null;
        }
    }
}
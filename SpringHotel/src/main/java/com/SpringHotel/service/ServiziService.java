package com.SpringHotel.service;

import com.SpringHotel.entity.Servizi;
import com.SpringHotel.repository.ServiziRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiziService {
    @Autowired
    ServiziRepository ServiziR;

    public List<Servizi> GetAll(){
        return ServiziR.findAll();
    }
    public Servizi addServizi(Servizi u){
        return ServiziR.save(u);
    }
    public String deleteByServiziId(Integer id){
        ServiziR.deleteById(id);
        return "Servizi Eliminato!";
    }
    public Servizi updateServizi(Integer id,Servizi u){
        Servizi utente= ServiziR.findById(id).orElse(null);
        if(utente!=null){
            return ServiziR.save(u);
        }
        else {
            return null;
        }
    }
}

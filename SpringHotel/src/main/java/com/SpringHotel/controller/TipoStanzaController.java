package com.SpringHotel.controller;

import com.SpringHotel.entity.Prenotazioni;
import com.SpringHotel.entity.TipoStanza;
import com.SpringHotel.repository.TipoStanzaRepository;
import com.SpringHotel.service.TipoStanzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/TipoStanza")
public class TipoStanzaController {
    @Autowired
    TipoStanzaService TipoStanzaS;
    @Autowired
    TipoStanzaRepository TipoStanzaR;

    @GetMapping("/getAll")
    public List<TipoStanza> GetAllTipoStanza(){

        return TipoStanzaS.GetAll();
    }
    @GetMapping("/getById/{id}")
    public TipoStanza GetTipoStanzaById(@PathVariable Integer id){
        return TipoStanzaR.findById(id).orElse(null);
    }
    @PostMapping("/add")
    public TipoStanza addTipoStanza(@RequestBody TipoStanza u){

        return TipoStanzaS.addTipoStanza(u);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTipoStanza(@PathVariable Integer id,TipoStanza u){
        return TipoStanzaS.deleteByTipoStanzaId(id);
    }
    @PutMapping("/update/{id}")
    public TipoStanza updateTipoStanza(@PathVariable Integer id,@RequestBody TipoStanza u){
        return TipoStanzaS.updateTipoStanza(id,u);
    }
}
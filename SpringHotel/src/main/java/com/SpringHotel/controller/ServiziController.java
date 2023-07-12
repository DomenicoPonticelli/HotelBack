package com.SpringHotel.controller;

import com.SpringHotel.entity.Servizi;
import com.SpringHotel.service.ServiziService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/Servizi")
public class ServiziController {
    @Autowired
    ServiziService ServiziS;

    @GetMapping("/getAll")
    public List<Servizi> GetAllServizi(){

        return ServiziS.GetAll();
    }
    @PostMapping("/add")
    public Servizi addServizi(@RequestBody Servizi u){

        return ServiziS.addServizi(u);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteServizi(@PathVariable Integer id,Servizi u){
        return ServiziS.deleteByServiziId(id);
    }
    @PutMapping("/update/{id}")
    public Servizi updateServizi(@PathVariable Integer id,@RequestBody Servizi u){
        return ServiziS.updateServizi(id,u);
    }
}
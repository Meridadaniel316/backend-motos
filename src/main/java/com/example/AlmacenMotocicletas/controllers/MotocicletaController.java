package com.example.AlmacenMotocicletas.controllers;

import com.example.AlmacenMotocicletas.DTOs.MotocicletaDTO;
import com.example.AlmacenMotocicletas.services.MotocicletaServiceCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/motocicletas")
public class MotocicletaController {

    @Autowired
    MotocicletaServiceCRUD motocicletaServiceCRUD;

    @GetMapping("/{id}")
    public ResponseEntity<MotocicletaDTO> findById(@PathVariable("id") String id){
        return new ResponseEntity(motocicletaServiceCRUD.getById(id), HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<MotocicletaDTO>> findAll(){
        return new ResponseEntity(motocicletaServiceCRUD.getAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<MotocicletaDTO> create(@RequestBody MotocicletaDTO motocicletaDTO){
        return new ResponseEntity(motocicletaServiceCRUD.create(motocicletaDTO), HttpStatus.CREATED);
    }

    @PutMapping("/modify")
    public ResponseEntity<MotocicletaDTO> update(@RequestBody MotocicletaDTO motocicletaDTO){
        if(motocicletaDTO.getId() != null){
            return new ResponseEntity(motocicletaServiceCRUD.modify(motocicletaDTO), HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") String id){
        try {
            motocicletaServiceCRUD.delete(id);
            return new ResponseEntity(HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
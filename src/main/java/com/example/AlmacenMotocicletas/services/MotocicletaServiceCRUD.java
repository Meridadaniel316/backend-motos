package com.example.AlmacenMotocicletas.services;

import com.example.AlmacenMotocicletas.DTOs.MotocicletaDTO;
import com.example.AlmacenMotocicletas.collections.Motocicleta;
import com.example.AlmacenMotocicletas.mappers.MotocicletaMapper;
import com.example.AlmacenMotocicletas.repositories.MotocicletaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotocicletaServiceCRUD {

    @Autowired
    MotocicletaRepository motocicletaRepository;
    MotocicletaMapper mapper = new MotocicletaMapper();

    //Get all motos
    public List<MotocicletaDTO> getAll(){
        List<Motocicleta> motocicletas = (List<Motocicleta>) motocicletaRepository.findAll();
        return mapper.fromCollectionList(motocicletas);
    }

    //Get motocicleta by id
    public MotocicletaDTO getById (String id){
        Motocicleta motocicleta = motocicletaRepository.findById(id).orElseThrow(() -> new RuntimeException("Motocicleta not found"));
        return mapper.fromCollection(motocicleta);
    }

    //Create motocicleta
    public MotocicletaDTO create(MotocicletaDTO motocicletaDTO){
        Motocicleta motocicleta = mapper.fromDTO(motocicletaDTO);
        return mapper.fromCollection(motocicletaRepository.save(motocicleta));
    }

    //Modify motocicleta
    public MotocicletaDTO modify(MotocicletaDTO motocicletaDTO){
        Motocicleta motocicleta = mapper.fromDTO(motocicletaDTO);
        motocicletaRepository.findById(motocicleta.getId()).orElseThrow(() -> new RuntimeException("Motocicleta not found"));
        return mapper.fromCollection(motocicletaRepository.save(motocicleta));
    }

    //Delete motocicleta
    public void delete (String id){
        motocicletaRepository.deleteById(id);
    }
}
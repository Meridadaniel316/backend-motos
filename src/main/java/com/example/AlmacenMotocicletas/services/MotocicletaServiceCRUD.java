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

        validationsNewProduct(motocicleta);
        
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

    private void validationsNewProduct(Motocicleta motocicleta) {
        if(motocicleta.getMarca().isEmpty() || motocicleta.getMarca().length() < 3){
            throw new Error("No hay una marca v??lida para guardar.");
        }
        if(motocicleta.getLinea().isEmpty() || motocicleta.getLinea().length() < 3){
            throw new Error("No hay una linea v??lida para guardar.");
        }
        if(motocicleta.getModelo().isEmpty() || motocicleta.getModelo().length() < 3){
            throw new Error("No hay un modelo v??lido para guardar.");
        }
        if(motocicleta.getCilindraje().isEmpty() || motocicleta.getCilindraje().length() < 2){
            throw new Error("El cilindraje debe ser v??lido para guardar.");
        }
        if(motocicleta.getValor().isEmpty() || motocicleta.getValor().length() < 2){
            throw new Error("El valor debe ser v??lido para guardar.");
        }
        if(motocicleta.getColor().isEmpty() || motocicleta.getColor().length() < 2){
            throw new Error("No hay un color v??lido para guardar.");
        }
        if(motocicleta.getImagen().isEmpty() || motocicleta.getImagen().length() < 2){
            throw new Error("No hay una imagen v??lida para guardar.");
        }
    }
}
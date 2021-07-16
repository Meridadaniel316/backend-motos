package com.example.AlmacenMotocicletas.mappers;

import com.example.AlmacenMotocicletas.DTOs.MotocicletaDTO;
import com.example.AlmacenMotocicletas.collections.Motocicleta;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MotocicletaMapper {

    //DTO to motocicleta
    public Motocicleta fromDTO(MotocicletaDTO motocicletaDTO){
        Motocicleta motocicleta = new Motocicleta();
        motocicleta.setId(motocicletaDTO.getId());
        motocicleta.setMarca(motocicletaDTO.getMarca());
        motocicleta.setLinea(motocicletaDTO.getLinea());
        motocicleta.setModelo(motocicletaDTO.getModelo());
        motocicleta.setCilindraje(motocicletaDTO.getCilindraje());
        motocicleta.setValor(motocicletaDTO.getValor());
        motocicleta.setColor(motocicletaDTO.getColor());
        motocicleta.setImagen(motocicletaDTO.getImagen());
        return motocicleta;
    }

    //Collection to MotocicletaDTO
    public MotocicletaDTO fromCollection(Motocicleta collection){
        MotocicletaDTO motocicletaDTO = new MotocicletaDTO();
        motocicletaDTO.setId(collection.getId());
        motocicletaDTO.setMarca(collection.getMarca());
        motocicletaDTO.setLinea(collection.getLinea());
        motocicletaDTO.setModelo(collection.getModelo());
        motocicletaDTO.setCilindraje(collection.getCilindraje());
        motocicletaDTO.setValor(collection.getValor());
        motocicletaDTO.setColor(collection.getColor());
        motocicletaDTO.setImagen(collection.getImagen());
        return motocicletaDTO;
    }

    //Collection list to DTO list
    public List<MotocicletaDTO> fromCollectionList(List<Motocicleta> collection){
        if (collection == null){
            return null;
        }

        List<MotocicletaDTO> list = new ArrayList(collection.size());
        Iterator listTracks = collection.iterator();

        while (listTracks.hasNext()){
            Motocicleta motocicleta = (Motocicleta) listTracks.next();
            list.add(fromCollection(motocicleta));
        }
        return list;
    }
}
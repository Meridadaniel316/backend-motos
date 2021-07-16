package com.example.AlmacenMotocicletas.repositories;

import com.example.AlmacenMotocicletas.collections.Motocicleta;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MotocicletaRepository extends MongoRepository <Motocicleta, String> {
}
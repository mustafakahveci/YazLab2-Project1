package com.yazlab2.project1.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.yazlab2.project1.entity.Metin;

public interface MetinRepository extends MongoRepository<Metin, String> {

	
}

package com.yazlab2.project1.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.yazlab2.project1.entity.Birlesik;

public interface BirlesikRepository extends MongoRepository<Birlesik, String> {

}

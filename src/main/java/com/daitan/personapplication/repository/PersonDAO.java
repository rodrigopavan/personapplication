package com.daitan.personapplication.repository;

import com.daitan.personapplication.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonDAO extends MongoRepository<Person,Integer> {
}

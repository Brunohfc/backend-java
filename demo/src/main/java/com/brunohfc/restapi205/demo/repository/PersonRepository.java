package com.brunohfc.restapi205.demo.repository;

import com.brunohfc.restapi205.demo.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}

package com.brunohfc.restapi205.demo.repository;

import com.brunohfc.restapi205.demo.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PersonRepository extends JpaRepository<Person, Long> {

    @Modifying(clearAutomatically = true) //removendo o cache do EntityManager para nao ter conflitos no banco
    @Query("UPDATE Person p SET p.enabled = false WHERE p.id =:id")
    void disabledPerson(@Param("id") Long id);
}

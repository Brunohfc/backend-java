package com.brunohfc.restapi205.demo.repository;

import com.brunohfc.restapi205.demo.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Books, Integer>{
}

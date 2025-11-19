package com.brunohfc.restapi205.demo.controller;

import com.brunohfc.restapi205.demo.model.Books;
import com.brunohfc.restapi205.demo.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService service;

    @GetMapping
    public List<Books> getAllBooks(){
        return service.getAllBooks();
    }

    @GetMapping("/{id}")
    public Books getBookById(@PathVariable int id){
        return service.getBookById(id);
    }

    @PostMapping("/create")
    public Books createBook(@RequestBody Books book){
        return service.createBook(book);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(int id){

        service.deleteBook(id);

        return ResponseEntity.noContent().build();
    }
}

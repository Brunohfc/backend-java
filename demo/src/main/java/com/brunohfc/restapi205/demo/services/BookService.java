package com.brunohfc.restapi205.demo.services;

import com.brunohfc.restapi205.demo.model.Books;
import com.brunohfc.restapi205.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public Books getBookById(int id){
        var book = bookRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Livro nao encontrado"));
        return book;
    }

    public List<Books> getAllBooks(){
        var books = bookRepository.findAll();
        return books;
    }

    public Books createBook(Books book){
        return bookRepository.save(book);
    }

    public void deleteBook(int id){
        bookRepository.deleteById(id);
    }
}

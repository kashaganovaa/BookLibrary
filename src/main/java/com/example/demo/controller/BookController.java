package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @PostMapping("/books")
    public Book create(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @GetMapping("/books")
    public Iterable<Book> getAll(){
        return bookRepository.findAll();
    }

    @GetMapping("/books/{name}")
    public List getByName(@PathVariable String name){
        return bookRepository.findByName(name);
    }

    @DeleteMapping("/books/{name}")
    public void delete(@PathVariable String name) {
        bookRepository.deleteByName(name);
    }

}

package com.example.mongoldb.Controller;

import com.example.mongoldb.Model.Book;
import com.example.mongoldb.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @PostMapping("/addBook")
    public Book saveBook(@RequestBody Book book){
        return bookRepository.save(book);
    }

    @GetMapping("/findAllBooks")
    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    @GetMapping("/findBook/{id}")
    public Optional<Book> getBook(@PathVariable int id){
        return bookRepository.findById(id);
    }

    @DeleteMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable int id){
        bookRepository.deleteById(id);
        return "deleted";
    }
}

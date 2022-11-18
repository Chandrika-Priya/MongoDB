package com.example.mongoldb.Repository;

import com.example.mongoldb.Model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, Integer> {
}

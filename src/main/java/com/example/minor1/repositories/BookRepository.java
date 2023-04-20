package com.example.minor1.repositories;

import com.example.minor1.models.Book;
import com.example.minor1.models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {


    List<Book> findByName(String name);


    List<Book> findByAuthor_Name(String authorName);

    List<Book> findByGenre(Genre genre);

}

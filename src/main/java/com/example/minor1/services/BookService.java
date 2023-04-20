package com.example.minor1.services;

import com.example.minor1.models.Author;
import com.example.minor1.models.Book;
import com.example.minor1.models.Genre;
import com.example.minor1.repositories.AuthorRepository;
import com.example.minor1.repositories.BookRepository;
import com.example.minor1.request.BookCreateRequest;
import com.example.minor1.request.BookFilterType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    public void createOrUpdate(BookCreateRequest bookCreateRequest){
        Book book = bookCreateRequest.to();
        createOrUpdate(book);
    }

    public void createOrUpdate(Book book){
        Author author = book.getAuthor();

        Author authorFromDB = authorRepository.findByEmail(author.getEmail());

        if(authorFromDB == null){
            authorFromDB = authorRepository.save(author);
        }

        book.setAuthor(authorFromDB);
        bookRepository.save(book);
    }

    public List<Book> find(BookFilterType bookFilterType, String value){

        switch (bookFilterType){
            case NAME:
                return bookRepository.findByName(value);
            case AUTHOR_NAME:
                return bookRepository.findByAuthor_Name(value);
            case GENRE:
                return bookRepository.findByGenre(Genre.valueOf(value));
            case BOOK_ID:
                return bookRepository
                        .findAllById(Collections.singletonList(Integer.parseInt(value)));
            default:
                return new ArrayList<>();
        }
    }


}

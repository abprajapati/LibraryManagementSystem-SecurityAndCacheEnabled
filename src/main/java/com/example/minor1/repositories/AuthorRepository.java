package com.example.minor1.repositories;

import com.example.minor1.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer> {


    Author findByEmail(String email);



    @Query(value = "select a from author a where a.email = ?1", nativeQuery = true)
    public Author getAuthorGivenEmailIdNativeQuery(String author_email);

    @Query("select a from Author a where a.email = ?1")
    public Author getAuthorGivenEmailIdJPQL(String author_email);


    @Query(value = "select a from author a where a.land = ?1", nativeQuery = true)
    public List<Author> getAuthorsByCountry(String country);

    @Query(value = "select a from Author a where a.country = ?1")
    public List<Author> getAuthorsByCountryJPQL(String country);


}

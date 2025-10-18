package com.example.books.Repository.Author;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.books.Entity.Author.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    boolean existsByFullName(String fullName);
}

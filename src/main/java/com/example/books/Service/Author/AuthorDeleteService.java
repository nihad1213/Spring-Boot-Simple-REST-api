package com.example.books.Service.Author;

import com.example.books.Entity.Author.Author;
import com.example.books.Repository.Author.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class AuthorDeleteService {
    private final AuthorRepository authorRepository;

    public Author deleteAuthor(Long id) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Author not Found"));
        authorRepository.delete(author);
        return author;
    }
}

package com.example.books.Service.Author;

import com.example.books.Dto.Author.Request.AuthorCreateDto;
import com.example.books.Entity.Author.Author;
import com.example.books.Repository.Author.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorCreateService {
    private final AuthorRepository authorRepository;

    public Author createAuthor(AuthorCreateDto dto) {
        if (authorRepository.existsByFullName(dto.getFullName())) {
            throw new RuntimeException("Author with this name already exists");
        }

        Author author = new Author();
        author.setFullName(dto.getFullName());

        return authorRepository.save(author);
    }
}

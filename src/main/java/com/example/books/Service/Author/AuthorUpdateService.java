package com.example.books.Service.Author;

import com.example.books.Dto.Author.Request.AuthorUpdateDto;
import com.example.books.Entity.Author.Author;
import com.example.books.Repository.Author.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorUpdateService {
    private final AuthorRepository authorRepository;

    public Author updateAuthor(Long id, AuthorUpdateDto dto) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found!"));

        if (!author.getFullName().equals(dto.getFullName()) && authorRepository.existsByFullName(dto.getFullName())) {
            throw new RuntimeException("Another author with this name already exists");
        }

        author.setFullName(dto.getFullName());
        return authorRepository.save(author);
    }
}

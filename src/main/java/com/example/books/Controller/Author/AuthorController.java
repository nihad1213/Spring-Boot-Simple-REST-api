package com.example.books.Controller.Author;

import com.example.books.Dto.Author.Request.AuthorCreateDto;
import com.example.books.Dto.Author.Request.AuthorUpdateDto;
import com.example.books.Dto.Author.Response.AuthorShowAllDto;
import com.example.books.Dto.Author.Response.AuthorShowDto;
import com.example.books.Entity.Author.Author;
import com.example.books.Repository.Author.AuthorRepository;
import com.example.books.Service.Author.AuthorCreateService;
import com.example.books.Service.Author.AuthorDeleteService;
import com.example.books.Service.Author.AuthorUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/author")
public class AuthorController {

    private final AuthorCreateService authorCreateService;
    private final AuthorUpdateService authorUpdateService;
    private final AuthorDeleteService authorDeleteService;
    private final AuthorRepository authorRepository;

    @GetMapping("/all")
    public ResponseEntity<List<AuthorShowAllDto>> getAllAuthors() {
        List<AuthorShowAllDto> response = authorRepository.findAll()
                .stream()
                .map(a -> new AuthorShowAllDto(a.getId(), a.getFullName()))
                .toList();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorShowDto> getAuthorById(@PathVariable Long id) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found"));

        AuthorShowDto response = new AuthorShowDto(author.getId(), author.getFullName());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/create")
    public ResponseEntity<Author> createAuthor(@RequestBody AuthorCreateDto dto) {
        Author createdAuthor = authorCreateService.createAuthor(dto);
        return ResponseEntity.ok(createdAuthor);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Author> updateAuthor(
            @PathVariable Long id,
            @RequestBody AuthorUpdateDto dto) {

        Author updatedAuthor = authorUpdateService.updateAuthor(id, dto);
        return ResponseEntity.ok(updatedAuthor);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Author> deleteAuthor(@PathVariable Long id) {
        Author deletedAuthor = authorDeleteService.deleteAuthor(id);
        return ResponseEntity.ok(deletedAuthor);
    }
}

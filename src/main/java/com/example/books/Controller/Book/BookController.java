package com.example.books.Controller.Book;

import com.example.books.Dto.Book.Request.BookCreateDto;
import com.example.books.Dto.Book.Request.BookUpdateDto;
import com.example.books.Dto.Book.Response.BookShowAllDto;
import com.example.books.Dto.Book.Response.BookShowDto;
import com.example.books.Entity.Book.Book;
import com.example.books.Repository.Book.BookRepository;
import com.example.books.Service.Book.BookCreateService;
import com.example.books.Service.Book.BookDeleteService;
import com.example.books.Service.Book.BookUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/book")
public class BookController {

    private final BookRepository bookRepository;
    private final BookCreateService bookCreateService;
    private final BookUpdateService bookUpdateService;
    private final BookDeleteService bookDeleteService;

    @GetMapping("/all")
    public ResponseEntity<List<BookShowAllDto>> getAllBooks() {
        List<BookShowAllDto> response = bookRepository.findAll()
                .stream()
                .map(b -> new BookShowAllDto(
                        b.getId(),
                        b.getTitle(),
                        b.getAuthor().getFullName(),
                        b.getGenres().stream().map(g -> g.getName()).toList()
                ))
                .toList();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookShowDto> getBookById(@PathVariable Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        BookShowDto response = new BookShowDto(
                book.getId(),
                book.getTitle(),
                book.getAuthor().getFullName(),
                book.getGenres().stream().map(g -> g.getName()).toList()
        );

        return ResponseEntity.ok(response);
    }

    @PostMapping("/create")
    public ResponseEntity<Book> createBook(@RequestBody BookCreateDto dto) {
        Book createdBook = bookCreateService.createBook(dto);
        return ResponseEntity.ok(createdBook);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody BookUpdateDto dto) {
        Book updatedBook = bookUpdateService.updateBook(id, dto);
        return ResponseEntity.ok(updatedBook);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable Long id) {
        Book deletedBook = bookDeleteService.deleteBook(id);
        return ResponseEntity.ok(deletedBook);
    }
}

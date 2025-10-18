package com.example.books.Service.Book;

import com.example.books.Dto.Book.Request.BookUpdateDto;
import com.example.books.Entity.Author.Author;
import com.example.books.Entity.Book.Book;
import com.example.books.Entity.Genre.Genre;
import com.example.books.Repository.Author.AuthorRepository;
import com.example.books.Repository.Book.BookRepository;
import com.example.books.Repository.Genre.GenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookUpdateService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final GenreRepository genreRepository;

    public Book updateBook(Long id, BookUpdateDto dto) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        if (dto.getTitle() != null && !dto.getTitle().isEmpty()) {
            if (!book.getTitle().equals(dto.getTitle()) && bookRepository.existsByTitle(dto.getTitle())) {
                throw new RuntimeException("Another book with this title already exists!");
            }
            book.setTitle(dto.getTitle());
        }

        if (dto.getAuthorId() != null) {
            Author author = authorRepository.findById(dto.getAuthorId())
                    .orElseThrow(() -> new RuntimeException("Author not found"));
            book.setAuthor(author);
        }

        if (dto.getGenreIds() != null && !dto.getGenreIds().isEmpty()) {
            List<Genre> genres = genreRepository.findAllById(dto.getGenreIds());
            book.setGenres(genres);
        }

        return bookRepository.save(book);
    }
}

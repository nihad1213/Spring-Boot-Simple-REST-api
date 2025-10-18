package com.example.books.Service.Book;

import com.example.books.Dto.Book.Request.BookCreateDto;
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
public class BookCreateService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final GenreRepository genreRepository;

    public Book createBook(BookCreateDto dto) {
        if (bookRepository.existsByTitle(dto.getTitle())) {
            throw new RuntimeException("Book with this title already exists!");
        }

        Author author = authorRepository.findById(dto.getAuthorId())
                .orElseThrow(() -> new RuntimeException("Author not found"));

        List<Genre> genres = genreRepository.findAllById(dto.getGenreIds());

        // Create and save the Book
        Book book = new Book();
        book.setTitle(dto.getTitle());
        book.setAuthor(author);
        book.setGenres(genres);

        return bookRepository.save(book);
    }
}

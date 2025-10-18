package com.example.books.Service.Book;

import com.example.books.Entity.Book.Book;
import com.example.books.Repository.Book.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookDeleteService {

    private final BookRepository bookRepository;

    public Book deleteBook(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        bookRepository.delete(book);

        book.setAuthor(null);
        book.setGenres(null);
        return book;
    }
}

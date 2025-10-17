package com.example.books.Service.Genre;

import com.example.books.Entity.Genre.Genre;
import com.example.books.Repository.Genre.GenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class GenreDeleteService {
    private final GenreRepository genreRepository;

    public Genre deleteGenre(Long id) {
        Genre genre = genreRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Genre not Found"));
        genreRepository.delete(genre);
        return genre;
    }
}

package com.example.books.Service.Genre;

import com.example.books.Dto.Genre.Request.GenreCreateDto;
import com.example.books.Entity.Genre.Genre;
import com.example.books.Repository.Genre.GenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GenreCreateService {
    private final GenreRepository genreRepository;

    public Genre createGenre(GenreCreateDto dto) {
        if (genreRepository.existsByName(dto.getName())) {
            throw new RuntimeException("Genre with this name already exists");
        }

        Genre genre = new Genre();
        genre.setName(dto.getName());

        return genreRepository.save(genre);
    }
}

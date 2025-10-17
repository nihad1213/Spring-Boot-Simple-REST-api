package com.example.books.Service.Genre;

import com.example.books.Dto.Genre.Request.GenreUpdateDto;
import com.example.books.Entity.Genre.Genre;
import com.example.books.Repository.Genre.GenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GenreUpdateService {

    private final GenreRepository genreRepository;

    public Genre updateGenre(Long id, GenreUpdateDto dto) {
        Genre genre = genreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Genre not found!"));

        if (!genre.getName().equals(dto.getName()) && genreRepository.existsByName(dto.getName())) {
            throw new RuntimeException("Another genre with this name already exists");
        }

        genre.setName(dto.getName());
        return genreRepository.save(genre);
    }
}

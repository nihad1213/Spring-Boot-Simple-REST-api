package com.example.books.Controller.Genre;

import com.example.books.Dto.Genre.Request.GenreCreateDto;
import com.example.books.Dto.Genre.Request.GenreUpdateDto;
import com.example.books.Dto.Genre.Response.GenreShowAllDto;
import com.example.books.Dto.Genre.Response.GenreShowDto;
import com.example.books.Entity.Genre.Genre;
import com.example.books.Repository.Genre.GenreRepository;
import com.example.books.Service.Genre.GenreCreateService;
import com.example.books.Service.Genre.GenreDeleteService;
import com.example.books.Service.Genre.GenreUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/genre")
public class GenreController {

    private final GenreCreateService genreCreateService;
    private final GenreUpdateService genreUpdateService;
    private final GenreDeleteService genreDeleteService;
    private final GenreRepository genreRepository;

    @GetMapping("/all")
    public ResponseEntity<List<GenreShowAllDto>> getAllGenres() {
        List<GenreShowAllDto> response = genreRepository.findAll()
                .stream()
                .map(g -> new GenreShowAllDto(g.getId(), g.getName()))
                .toList();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenreShowDto> getGenreById(@PathVariable Long id) {
        Genre genre = genreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Genre not found"));

        GenreShowDto response = new GenreShowDto(genre.getId(), genre.getName());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/create")
    public ResponseEntity<Genre> createGenre(@RequestBody GenreCreateDto dto) {
        Genre createdGenre = genreCreateService.createGenre(dto);
        return ResponseEntity.ok(createdGenre);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Genre> updateGenre(
            @PathVariable Long id,
            @RequestBody GenreUpdateDto dto) {

        Genre updatedGenre = genreUpdateService.updateGenre(id, dto);
        return ResponseEntity.ok(updatedGenre);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Genre> deleteGenre(@PathVariable Long id) {
        Genre deletedGenre = genreDeleteService.deleteGenre(id);
        return ResponseEntity.ok(deletedGenre);
    }
}

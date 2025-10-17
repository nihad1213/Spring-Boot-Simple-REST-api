package com.example.books.Controller.Genre;

import com.example.books.Dto.Genre.Request.GenreCreateDto;
import com.example.books.Dto.Genre.Request.GenreUpdateDto;
import com.example.books.Entity.Genre.Genre;
import com.example.books.Service.Genre.GenreCreateService;
import com.example.books.Service.Genre.GenreUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/genre")
public class GenreController {

    private final GenreCreateService genreCreateService;
    private final GenreUpdateService genreUpdateService;

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
}

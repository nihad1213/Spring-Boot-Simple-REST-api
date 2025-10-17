package com.example.books.Controller.Genre;

import com.example.books.Dto.Genre.Request.GenreCreateDto;
import com.example.books.Entity.Genre.Genre;
import com.example.books.Service.Genre.GenreCreateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/genre/")
public class GenreController {

    private final GenreCreateService genreCreateService;

    @PostMapping("/create")
    public ResponseEntity<Genre> createGenre(@RequestBody GenreCreateDto dto) {
        Genre createdGenre = genreCreateService.createGenre(dto);
        return ResponseEntity.ok(createdGenre);
    }
}

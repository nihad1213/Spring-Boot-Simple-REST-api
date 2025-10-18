package com.example.books.Dto.Book.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookShowAllDto {
    private Long id;
    private String title;
    private String authorName;
    private List<String> genres;
}

package com.example.books.Dto.Book.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookUpdateDto {
    private String title;
    private Long authorId;
    private List<Long> genreIds;
}

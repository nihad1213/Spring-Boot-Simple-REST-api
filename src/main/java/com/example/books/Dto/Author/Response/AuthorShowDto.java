package com.example.books.Dto.Author.Response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthorShowDto {
    private Long id;
    private String fullName;
}

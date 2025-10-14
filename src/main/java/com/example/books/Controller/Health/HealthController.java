package com.example.books.Controller.Health;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import javax.sql.DataSource;
import java.sql.Connection;

@RequiredArgsConstructor
@RestController
public class HealthController {
    private final DataSource dataSource;

    public HealthController(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @GetMapping("/api/health")
    public String health() {
        try (Connection connection = dataSource.getConnection()) {
            if (connection.isValid(2)) {
                return "Connection is OK!";
            }
        } catch (Exception e) {
            return "Connection is FAILED!";
        }

        return "UNKNOWN!";
    }
}

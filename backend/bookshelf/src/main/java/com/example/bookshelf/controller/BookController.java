package com.example.bookshelf.controller;

import com.example.bookshelf.dto.Book;
import com.example.bookshelf.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BookController {
    
    private final BookService bookService;
    
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    
    @GetMapping("/random-book")
    public ResponseEntity<?> getRandomBook() {
        try {
            Book randomBook = bookService.getRandomBook();
            return ResponseEntity.ok(randomBook);
        } catch (RuntimeException e) {
            // Service layer errors
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Error: " + e.getMessage());
        } catch (Exception e) {
            // Unexpected errors
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Unexpected error occurred");
        }
    }
}
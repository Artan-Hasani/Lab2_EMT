package com.example.lab2_backend.web.rest;


import com.example.lab2_backend.model.Books;
import com.example.lab2_backend.model.dto.BookDTO;
import com.example.lab2_backend.model.enumeration.Category;
import com.example.lab2_backend.service.Int.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/books")
public class BooksRestController {

    private final BookService bookService;

    public BooksRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Books> getBooks(){
        return bookService.listAllBooks();
    }

    @GetMapping("/categories")
    public List<Category> getCategories(){
        return Arrays.asList(Category.values().clone());
    }


    @PostMapping("/create")
    public ResponseEntity<Books> create(@RequestBody BookDTO bookDto) throws Exception {
        return this.bookService.create(bookDto)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Books> getBook(@PathVariable Long id) throws Exception {
        return this.bookService.findById(id)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Books> edit(@PathVariable Long id, @RequestBody BookDTO bookDto) throws Exception {
        return this.bookService.edit(id, bookDto)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id) throws Exception {
        this.bookService.delete(id);
        if(this.bookService.findById(id).isEmpty()) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/take/{id}")
    public ResponseEntity takeBook(@PathVariable Long id) throws Exception {

        Books bookBefore = this.bookService.findById(id).orElseThrow(Exception::new);

        int taken = bookBefore.getAvailableCopies();
        Books bookAfter = this.bookService.markAsTaken(id);
        if(this.bookService.checkCopies(bookAfter,taken)) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }
}

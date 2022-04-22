package com.example.lab2_backend.service.Int;


import com.example.lab2_backend.model.Books;
import com.example.lab2_backend.model.dto.BookDTO;
import com.example.lab2_backend.model.enumeration.Category;


import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Books> listAllBooks();
    Optional<Books> create(String name, Category category, Long authorId, Integer availableCopies) throws Exception;
    Optional<Books> create(BookDTO bookDTO) throws Exception;

    // required functions
    // Edit, Delete, Mark As Taken
    Optional<Books> edit(Long id, String name, Category category, Long authorId, Integer availableCopies) throws Exception;
   Optional<Books> edit(Long id, BookDTO bookDTO) throws Exception;
    Books delete(Long id) throws Exception;
    Books markAsTaken(Long id) throws Exception;
    boolean checkCopies(Books book1, int taken);
   Optional<Books> findById(Long id) throws Exception;
}

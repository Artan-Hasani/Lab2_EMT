package com.example.lab2_backend.service.Impl;

import com.example.lab2_backend.model.Author;
import com.example.lab2_backend.model.Books;
import com.example.lab2_backend.model.dto.BookDTO;
import com.example.lab2_backend.model.enumeration.Category;
import com.example.lab2_backend.repository.AuthorRepository;
import com.example.lab2_backend.repository.BookRepository;
import com.example.lab2_backend.service.Int.BookService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {


    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;


    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Books> listAllBooks() {
        return this.bookRepository.findAll();
    }

    @Override
    @Transactional
    public Optional<Books> create(String name, Category category, Long authorId, Integer availableCopies) throws Exception {

        Author author=this.authorRepository.findById(authorId).orElseThrow(Exception::new);
        Books book = new Books(name,category,author,availableCopies);
        return Optional.of(this.bookRepository.save(book)) ;
    }

    @Override
    public Optional<Books> create(BookDTO bookDTO) throws Exception {

        Author author=this.authorRepository.findById(bookDTO.getAuthor()).orElseThrow(Exception::new);
        Books book = new Books(bookDTO.getName(),bookDTO.getCategory(),author,bookDTO.getAvailableCopies());
       return Optional.of(this.bookRepository.save(book)) ;
    }

    @Override
    @Transactional
    public Optional<Books> edit(Long id, String name, Category category, Long authorId, Integer availableCopies) throws Exception {

        Author author=this.authorRepository.findById(authorId).orElseThrow(Exception::new);
        Books book = this.bookRepository.findById(id).orElseThrow(Exception::new);

        book.setName(name);
        book.setCategory(category);
        book.setAuthor(author);
        book.setAvailableCopies(availableCopies);


       return Optional.of(this.bookRepository.save(book)) ;
    }

    @Override
    public Optional<Books> edit(Long id, BookDTO bookDTO) throws Exception {

        Books book = this.bookRepository.findById(id).orElseThrow(Exception::new);
        Author author=this.authorRepository.findById(bookDTO.getAuthor()).orElseThrow(Exception::new);
        book.setName(bookDTO.getName());
        book.setCategory(bookDTO.getCategory());
        book.setAuthor(author);
        book.setAvailableCopies(bookDTO.getAvailableCopies());

        return Optional.of(this.bookRepository.save(book)) ;
    }

    @Override
    public Books delete(Long id) throws Exception {

        Books book = this.bookRepository.findById(id).orElseThrow(Exception::new);

        this.bookRepository.delete(book);
        return book;
    }

    @Override
    public Books markAsTaken(Long id) throws Exception {

        Books book = this.bookRepository.findById(id).orElseThrow(Exception::new);
        book.setAvailableCopies(book.getAvailableCopies()-1);
        return this.bookRepository.save(book);
    }

    @Override
    public Optional<Books> findById(Long id) throws Exception {
        return this.bookRepository.findById(id);
    }

    @Override
    public boolean checkCopies(Books book1, int taken){
        return  (book1.getAvailableCopies()<taken);
    }
}

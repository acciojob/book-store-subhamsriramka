package com.driver;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class BookService {
    
    @Autowired
    BookRepository bookRepository;

    public Book createBook(Book book){

        return bookRepository.save(book);
    }

    public Book findBookById(int id){

        return bookRepository.findBookById(id);
    }

    public void deleteBookById(int id){

        bookRepository.deleteBookById(id);
    }

    public List<Book> findAllBooks(){
        return bookRepository.findAll();
    }

    public void deleteAllBooks(){
        bookRepository.deleteAll();
    }

    public List<Book> findBooksByAuthor(String author){
        return bookRepository.findBooksByAuthor(author);
    }

    public List<Book> findBooksByGenre(String genre){
        return bookRepository.findBooksByGenre(genre);
    }
}

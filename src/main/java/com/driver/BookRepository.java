package com.driver;
import java.util.*;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public class BookRepository {

    Map<Integer, Book> bookMap;
    public BookRepository(){
        bookMap = new HashMap<>();
    }

    public Book save(Book book){
        int number = bookMap.size() + 1;
        book.setId(number);
        bookMap.put(number, book);
        return book;
    }

    public Book findBookById(int id){

        return bookMap.get(id);
    }

    public List<Book> findAll(){
        List<Book> books = new ArrayList<>();

        for (Book b: bookMap.values())
            books.add(b);

        return books;
    }

    public void deleteBookById(int id){
        bookMap.remove(id);
        return;
    }

    public void deleteAll(){
        bookMap.clear();
        return;
    }

    public List<Book> findBooksByAuthor(String author){
        List<Book> books = new ArrayList<>();

        for (Book book: bookMap.values()) {
            if(book.getAuthor().equals(author)) {
                books.add(book);
            }
        }

        return books;
    }

    public List<Book> findBooksByGenre(String genre){
        List<Book> books = new ArrayList<>();

        for (Book book: bookMap.values()) {
            if (book.getGenre().equals(genre))
                books.add(book);
        }

        return books;
    }
}

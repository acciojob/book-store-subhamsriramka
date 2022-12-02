package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("books")
public class BookController {
    @Autowired
    BookService bookService;

    // One example controller, make the rest by yourself
    @PostMapping("/create-book")
    public ResponseEntity createBook(@RequestBody Book book){
        bookService.createBook(book);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/get-book-by-id/{id}")
    public ResponseEntity<Book> getBookBuId(@PathVariable int id) {
        return new ResponseEntity<>(bookService.findBookById(id), HttpStatus.ACCEPTED);
    }

    @GetMapping("/get-all-books")
    public ResponseEntity<List<Book>> getAllBooks() {
        return new ResponseEntity<>(bookService.findAllBooks(), HttpStatus.FOUND);
    }

    @GetMapping("/get-books-by-author")
    public ResponseEntity<List<Book>> getBookByAuthor(@RequestParam String author) {
        return new ResponseEntity<>(bookService.findBooksByAuthor(author), HttpStatus.FOUND);
    }

    @GetMapping("/get-books-by-genre")
    public ResponseEntity<List<Book>> getBookByGenre(@RequestParam String genre) {
        return new ResponseEntity<>(bookService.findBooksByGenre(genre), HttpStatus.FOUND);
    }

    @DeleteMapping("/delete-book-by-id/{id}")
    public ResponseEntity deleteById(@PathVariable int id) {
        bookService.deleteBookById(id);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete-all-books")
    public ResponseEntity deleteAllBooks() {
        bookService.deleteAllBooks();
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}

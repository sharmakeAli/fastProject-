package com.example.fastProject.books;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/books")
public class BookController {
  /*
  Constructor-Based Dependency Injection
   The BookController class uses constructor-based dependency injection
    to obtain a reference to the BookService.
    This approach is recommended in Spring as it makes
    your beans immutable and ensures
    that required dependencies are not null.
*/
  private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Book savedBook = bookService.saveBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Book book = bookService.findBookById(id); // Assume this method fetches a book by ID
        if (book == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(book);
    }
    @GetMapping
    public ResponseEntity<Collection<Book>> getAllBooks() {
        Collection<Book> books = bookService.findAllBooks();
        return ResponseEntity.ok(books);
    }
}

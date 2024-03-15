package com.example.fastProject.books;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class BookService {
    private final Map<Long, Book> books = new ConcurrentHashMap<>();
    private final AtomicLong counter = new AtomicLong();
    public Collection<Book> findAllBooks() {
        return books.values();
    }

    public Book findBookById(Long id) {
        return books.get(id);
    }

    public Book saveBook(Book book) {
        Long id = book.getId() != null ? book.getId() : counter.incrementAndGet();
        book.setId(id);
        books.put(id, book);
        return book;
    }
}

package com.example.spring_week5_day5_pro.Controller;

import com.example.spring_week5_day5_pro.Model.Book;
import com.example.spring_week5_day5_pro.Service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/book")
@RequiredArgsConstructor
public class BookController
{
    private final BookService bookService;
    @GetMapping("/get")
    public ResponseEntity getBook()
    {
        List<Book> bookList = bookService.getBook();
        return ResponseEntity.status(200).body(bookList);
    }
    @PostMapping("/add")
    public ResponseEntity addBook(@Valid @RequestBody Book book)
    {
        bookService.addBook(book);
        return ResponseEntity.status(200).body("Book added!");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateBook(@PathVariable Integer id,@Valid @RequestBody Book book)
    {
        bookService.updateBook(id, book);
        return ResponseEntity.status(200).body("Book updated!");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBook(@PathVariable Integer id)
    {
        bookService.deleteBook(id);
        return ResponseEntity.status(200).body("Book deleted!");
    }
    @PutMapping("/{bookId}/store/{storeId}")
    public ResponseEntity assignStoreWithBook(@PathVariable Integer bookId,@PathVariable Integer storeId)
    {
        bookService.assignStoreWithBook(bookId,storeId);
        return ResponseEntity.status(200).body("Store assigned with book!");
    }
    @GetMapping("/rabbs/{id}")
    public ResponseEntity returnAllBooksByStore(@PathVariable Integer id)
    {
        List<String> bookList = bookService.returnAllBooksByStore(id);
        return ResponseEntity.status(200).body(bookList);
    }
    @GetMapping("/rbcbbi/{id}")
    public ResponseEntity returnBooksCountByBookId(@PathVariable Integer id)
    {
        Integer booksCount = bookService.returnBooksCountByBookId(id);
        return ResponseEntity.status(200).body(booksCount);
    }
    @GetMapping("/returnBookInfo")
    public ResponseEntity returnBookInfo(@Valid @RequestBody String name)
    {
        Book book = bookService.returnBookInfo(name);
        return ResponseEntity.status(200).body(book);
    }
    @GetMapping("/rabsg/{genre}")
    public ResponseEntity returnAllBooksSameGenre(@PathVariable String genre)
    {
        List<String > bookList = bookService.returnAllBooksSameGenre(genre);
        return ResponseEntity.status(200).body(bookList);
    }
}

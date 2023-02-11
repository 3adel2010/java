package com.example.spring_week5_day5_pro.Service;

import com.example.spring_week5_day5_pro.ApiException.ApiException;
import com.example.spring_week5_day5_pro.DTO.StoreDTO;
import com.example.spring_week5_day5_pro.Model.Book;
import com.example.spring_week5_day5_pro.Model.Customer;
import com.example.spring_week5_day5_pro.Model.Store;
import com.example.spring_week5_day5_pro.Repository.BookRepository;
import com.example.spring_week5_day5_pro.Repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService
{
    private final BookRepository bookRepository;
    private final StoreRepository storeRepository;
    public List<Book> getBook()
    {
        return bookRepository.findAll();
    }
    public void addBook(Book book)
    {
        bookRepository.save(book);
    }
    public boolean updateBook(Integer id,Book book)
    {
        Book book1 = bookRepository.findBookById(id);
        if(book1==null)
            return false;
        book.setId(id);
        bookRepository.save(book);
        bookRepository.save(book);
        return true;
    }
    public boolean deleteBook(Integer id)
    {
        Book book = bookRepository.findBookById(id);
        if(book==null)
            return false;
        bookRepository.delete(book);
        return true;
    }

    public void assignStoreWithBook(Integer storeId,Integer bookId)
    {
        Store store = storeRepository.findStoreById(storeId);
        Book book = bookRepository.findBookById(bookId);
        if(store==null||book==null)
            throw new ApiException("ID not found!");
        book.setStore(store);
        bookRepository.save(book);
    }
    public List<String> returnAllBooksByStore(Integer id)
    {
        Store store = storeRepository.findStoreById(id);
        if(store==null)
            throw new ApiException("Wrong id");

        List<String> booksName = new ArrayList<>();

        for (Book c: store.getBook())
        {
            booksName.add(c.getName());
        }
        return booksName;
    }
    public Integer returnBooksCountByBookId(Integer id)
    {
        Book book = bookRepository.findBookById(id);
        if(book==null)
            throw new ApiException("Wrong Id!");
        return book.getBookCount();
    }
    public Book returnBookInfo(String book)
    {
        String result = "";
        Book bookClone = new Book();

        if (book != null && book.length() >= 2 && book.charAt(0) == '\"' && book.charAt(book.length() - 1) == '\"')
            result = book.substring(1, book.length() - 1);
        else
            result = book;
        for (Book b : bookRepository.findAll())
        {
            if(b.getName().equalsIgnoreCase(result))
            {
                bookClone.setName(b.getName());
                bookClone.setBookCount(b.getBookCount());
                bookClone.setGenre(b.getGenre());
                bookRepository.save(bookClone);
            }
        }
        return bookClone;
    }
    public List<String > returnAllBooksSameGenre(String genre)
    {
        String result = "";
        List<String> BooksName = new ArrayList<>();

        if (genre != null && genre.length() >= 2 && genre.charAt(0) == '\"' && genre.charAt(genre.length() - 1) == '\"')
            result = genre.substring(1, genre.length() - 1);
        else
            result = genre;

        for (Book b : bookRepository.findAll())
        {
            if(b.getGenre().equalsIgnoreCase(result))
                BooksName.add(b.getName().toString());
        }
        return BooksName;
    }
}

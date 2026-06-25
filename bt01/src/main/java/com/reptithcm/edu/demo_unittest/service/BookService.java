package com.reptithcm.edu.demo_unittest.service;

import com.reptithcm.edu.demo_unittest.dto.BookDtoRequest;
import com.reptithcm.edu.demo_unittest.entity.Book;
import com.reptithcm.edu.demo_unittest.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public List<Book> getAllBook(){
        return bookRepository.findAll();
    }

    public Book getBookById(Long id){
        return bookRepository.findById(id).orElseThrow();
    }

    public Book addBook(BookDtoRequest request){
        Book book = new Book();
        book.setAuthor(request.getAuthor());
        book.setTitle(request.getTitle());
        book.setPage(request.getPage());

        return bookRepository.save(book);
    }

    public Book updateBook(Long id, BookDtoRequest request){
        Book book = bookRepository.findById(request.getId()).orElseThrow();

        book.setAuthor(request.getAuthor());
        book.setTitle(request.getTitle());
        book.setPage(request.getPage());

        return bookRepository.save(book);
    }

    public boolean deleteBook(Long id){
        Book book = bookRepository.findById(id).orElseThrow();
        bookRepository.delete(book);
        return true;
    }

}

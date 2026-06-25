package com.reptithcm.edu.demo_unittest.controller;

import com.reptithcm.edu.demo_unittest.dto.BookDtoRequest;
import com.reptithcm.edu.demo_unittest.entity.Book;
import com.reptithcm.edu.demo_unittest.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class BookController {
    // Lấy tất cả sách
    // Lấy sách theo ID
    // Thêm sách mới (ID tự sinh)
    // Cập nhật toàn bộ thông tin sách
    // Xóa sách
    private final BookService bookService;

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBook(){
        return ResponseEntity.ok(bookService.getAllBook());
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id){
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    @PostMapping("/books")
    public ResponseEntity<Book> createBook(@RequestBody BookDtoRequest request){
        return ResponseEntity.ok(bookService.addBook(request));
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<Book> updateBookById(@PathVariable Long id, @RequestBody BookDtoRequest request){
        return ResponseEntity.ok(bookService.updateBook(id, request));
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Boolean> deleteBook(@PathVariable Long id){
        return ResponseEntity.ok(bookService.deleteBook(id));
    }

}

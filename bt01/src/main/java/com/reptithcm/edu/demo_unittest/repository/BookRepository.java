package com.reptithcm.edu.demo_unittest.repository;

import com.reptithcm.edu.demo_unittest.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    void removeBookById(Long id);
}

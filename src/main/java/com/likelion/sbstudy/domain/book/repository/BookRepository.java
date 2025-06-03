package com.likelion.sbstudy.domain.book.repository;

import com.likelion.sbstudy.domain.book.entity.Book;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByAuthor(String author);
    List<Book> findByTitle(String title);

}

package com.likelion.sbstudy.domain.book.service;

import com.likelion.sbstudy.domain.book.dto.request.CreateBookRequest;
import com.likelion.sbstudy.domain.book.dto.request.UpdateBookRequest;
import com.likelion.sbstudy.domain.book.dto.response.BookResponse;
import com.likelion.sbstudy.domain.book.entity.Book;
import com.likelion.sbstudy.domain.book.repository.BookRepository;
import com.likelion.sbstudy.global.exception.CustomException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookService {

    private final BookRepository bookRepository;

    //책 생성
    @Transactional
    public BookResponse createBook(CreateBookRequest createBookRequest) {
        log.info("[BookService] createBook : title = {}, author ={}", createBookRequest.getTitle(), createBookRequest.getAuthor());
        Book book = Book.builder()
            .title(createBookRequest.getTitle())
            .author(createBookRequest.getAuthor())
            .publisher(createBookRequest.getPublisher())
            .price(createBookRequest.getPrice())
            .description(createBookRequest.getDescription())
            .category(createBookRequest.getCategory())
            .publishedDate(createBookRequest.getPublishedDate())
            .build();
        bookRepository.save(book);
        log.info("[BookService] createBook : {}", book);
        return toBookResponse(book);
    }

    //책 전체 조회
    @Transactional
    public List<BookResponse> getAllBooks() {
        log.info("[BookService] getAllBooks");
        List<Book> bookList = bookRepository.findAll();
        log.info("[BookService] getAllBooks size : {}", bookList.size());
        return bookList.stream().map(this::toBookResponse).toList();
    }

    //책 단일 조회
    @Transactional
    public BookResponse getBookById(Long id) {
        log.info("[BookService] getBookById id = {}", id);
        Book book = bookRepository.findById(id)
        .orElseThrow(()->{
            log.warn("[BookService] getBookById error : id={}", id);
            return new Error("error");
        });
        log.info("[BookService] getBookById : id = {}", id);
        return toBookResponse(book);
    }

    //책 수정
    @Transactional
    public BookResponse updateBook(Long id, UpdateBookRequest updateBookRequest) {
        log.info("[BookService] updateBook id = {} ", id);
        Book book = bookRepository.findById(id)
            .orElseThrow(()->{
                log.warn("[BookService] getBookById error : id={}", id);
                return new Error("error");
            });
        book.update(
            updateBookRequest.getTitle(),
            updateBookRequest.getAuthor(),
            updateBookRequest.getPublisher(),
            updateBookRequest.getPrice(),
            updateBookRequest.getDescription(),
            updateBookRequest.getCategory(),
            updateBookRequest.getPublishedDate());
        log.info("[BookService] updateBook : id = {}", id);
        return toBookResponse(book);
    }
    //책 삭제
    @Transactional
    public Boolean deleteBook(Long id) {
        log.info("[BookService] deleteBook id = {}", id);
        Book book = bookRepository.findById(id)
            .orElseThrow(()->{
                log.warn("[BookService] getBookById error : id={}", id);
                return new Error("error");
            });
        bookRepository.deleteById(id);
        log.info("[BookService] deleteBook : id = {}", id);
        return true;
    }

    //Entity를 DTO로 변환해주는 메소드
    public BookResponse toBookResponse(Book book) {
        return BookResponse.builder()
            .bookId(book.getBookId())
            .title(book.getTitle())
            .author(book.getAuthor())
            .publisher(book.getPublisher())
            .price(book.getPrice())
            .description(book.getDescription())
            .category(book.getCategory())
            .publishedDate(book.getPublishedDate())
            .build();
    }
}

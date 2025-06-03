package com.likelion.sbstudy.domain.book.controller;

import com.likelion.sbstudy.domain.book.dto.request.CreateBookRequest;
import com.likelion.sbstudy.domain.book.dto.request.UpdateBookRequest;
import com.likelion.sbstudy.domain.book.dto.response.BookResponse;
import com.likelion.sbstudy.domain.book.service.BookService;
import com.likelion.sbstudy.global.response.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
@Tag(name="Post", description = "책 관련 API")
public class BookController {

    private final BookService bookService;

    @Operation(summary = "책 추가", description = "책 목록 페이지에서 책을 추가하는 API")
    @PostMapping("/books")
    public ResponseEntity<BaseResponse<BookResponse>> createBook(
        @Parameter(description = "책 추가하기") @RequestBody CreateBookRequest createBookRequest) {
        BookResponse response = bookService.createBook(createBookRequest);
        return ResponseEntity.ok(BaseResponse.success("책 생성 성공", response));
    }

    @Operation(summary = "책 전체 조회", description = "책 목록 페이지로 이동될 때 쓰는 API")
    @GetMapping("/books")
    public ResponseEntity<BaseResponse<List<BookResponse>>> getAllBooks() {
        List<BookResponse> response = bookService.getAllBooks();
        return ResponseEntity.ok(BaseResponse.success(response));
    }

    @Operation(summary = "책 단일 조회", description = "책 목록 페이지에서 특정 책에 접근할 때 요청되는 API")
    @GetMapping("/books/{bookId}")
    public ResponseEntity<BaseResponse<BookResponse>> getBookById(
        @Parameter(description = "특정 책 ID") @PathVariable long bookId) {
        BookResponse response = bookService.getBookById(bookId);
        return ResponseEntity.ok(BaseResponse.success(bookId + "번 책 조회 성공", response));
    }

    @Operation(summary = "책 수정", description = "책 페이지에서 책 정보 수정 후 수정 완료 버튼을 눌렀을 때 요청되는 API")
    @PutMapping("/books/{bookId}")
    public ResponseEntity<BaseResponse<BookResponse>> updateBook(
        @Parameter(description = "특정 책 ID") @PathVariable long bookId,
        @Parameter(description = "책 수정 내용") @RequestBody UpdateBookRequest updateBookRequest){
        BookResponse response = bookService.updateBook(bookId, updateBookRequest);
        return ResponseEntity.ok(BaseResponse.success(bookId+"번 책 수정 성공", response));
    }

    @Operation(summary = "책 삭제", description = "책 페이지에서 책 삭제 버튼을 눌렀을 때 요청되는 API")
    @DeleteMapping("/books/{bookId}")
    public ResponseEntity<BaseResponse<Boolean>> deleteBook(
        @Parameter(description = "특정 책 ID")
        @PathVariable long bookId) {
        Boolean response = bookService.deleteBook(bookId);
        return ResponseEntity.ok(BaseResponse.success(bookId+"번 책 삭제 성공", response));
    }
}

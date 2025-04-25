package com.likelion.sbstudy.domain.book.controller;

import com.likelion.sbstudy.domain.book.dto.request.CreateBookRequest;
import com.likelion.sbstudy.domain.book.dto.request.UpdateBookRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
@Tag(name="Post", description = "책 관련 API")
public class BookController {

    @Operation(summary = "책 추가", description = "책 목록 페이지에서 책을 추가하는 API")
    @PostMapping("/books")
    public String createBook(@Parameter(description = "책 추가하기") @RequestBody CreateBookRequest createBookRequest) {
        return "책 추가";
    }

    @Operation(summary = "책 전체 조회", description = "책 목록 페이지로 이동될 때 쓰는 API")
    @GetMapping("/books")
    public String getAllBooks() {
        return "책 목록 전체 조회";
    }

    @Operation(summary = "책 단일 조회", description = "책 목록 페이지에서 특정 책에 접근할 때 요청되는 API")
    @GetMapping("/books/{bookId}")
    public String getBookById(@Parameter(description = "특정 책 ID") @PathVariable long bookId) {
        return bookId + "번 책 조회";
    }

    @Operation(summary = "책 수정", description = "책 페이지에서 책 정보 수정 후 수정 완료 버튼을 눌렀을 때 요청되는 API")
    @PutMapping("/books/{bookId}")
    public String updateBook(@Parameter(description = "특정 책 ID") @PathVariable long bookId,
        @Parameter(description = "책 수정 내용") @RequestBody UpdateBookRequest updateBookRequest){
        return bookId + "번 책 수정";
    }

    @Operation(summary = "책 삭제", description = "책 페이지에서 책 삭제 버튼을 눌렀을 때 요청되는 API")
    @DeleteMapping("/books/{bookId}")
    public String deleteBook(@Parameter(description = "특정 책 ID") @PathVariable long bookId) {
        return bookId + "번 책 삭제";
    }
}

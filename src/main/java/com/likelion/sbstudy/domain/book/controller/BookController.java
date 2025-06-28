package com.likelion.sbstudy.domain.book.controller;

import com.likelion.sbstudy.domain.book.dto.request.CreateBookRequest;
import com.likelion.sbstudy.domain.book.dto.request.UpdateBookRequest;
import com.likelion.sbstudy.domain.book.dto.response.BookResponse;
import com.likelion.sbstudy.domain.book.service.BookService;
import com.likelion.sbstudy.global.response.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/books")
@Tag(name = "Book", description = "책 관련 API")
public class BookController {

    private final BookService bookService;

    @Operation(
            summary = "새 책 등록",
            description = "새로운 책을 등록하고, 등록된 책 정보를 반환합니다. (201 Created)")
    @PostMapping(value = "", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<BaseResponse<BookResponse>> createBook(
            @Parameter(content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
            @RequestPart(value = "book") @Valid CreateBookRequest request,
            @Parameter(description = "책 이미지들",
                    content = @Content(mediaType = MediaType.MULTIPART_FORM_DATA_VALUE))
            @RequestPart(value = "images")
            List<MultipartFile> images) {
        BookResponse response = bookService.createBook(request, images);
        return ResponseEntity.ok(BaseResponse.success("책 생성에 성공하였습니다.", response));
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

package com.likelion.sbstudy.domain.book.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
@Schema(title = "CreateBookRequest : 책 생성 요청 DTO")
public class CreateBookRequest {

    @Schema(description = "책 제목", example = "그리고 아무도 없었다")
    private String title;

    @Schema(description = "작가", example = "아가사 크리스티")
    private String author;

    @Schema(description = "출판사", example = "꿈나무책")
    private String publisher;

    @Schema(description = "가격", example = "20000")
    private int price;

    @Schema(description = "책 설명", example = "한 곳에 초대된 사람들.. 그리고 하나 둘 죽어가는데..")
    private String description;

    @Schema(description = "카테고리", example = "추리/미스테리")
    private String category;

    @Schema(description = "출간날짜", example = "2025년 3월 22일")
    private String publishDate;

}

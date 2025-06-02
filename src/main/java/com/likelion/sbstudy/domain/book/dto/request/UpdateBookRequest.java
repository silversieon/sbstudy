package com.likelion.sbstudy.domain.book.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
@Schema(title = "UpdateBookRequest : 책 수정 요청 DTO")
public class UpdateBookRequest {

    @Schema(description = "책 제목", example = "노르웨이의 숲")
    private String title;

    @Schema(description = "작가", example = "무라카미 하루키")
    private String author;

    @Schema(description = "출판사", example = "한빛")
    private String publisher;

    @Schema(description = "가격", example = "17000")
    private int price;

    @Schema(description = "책 설명", example = "한 남자가 오랜 시간 지내던 여자와 헤어지고..")
    private String description;

    @Schema(description = "카테고리", example = "연애/로맨스")
    private String category;

    @Schema(description = "출간날짜", example = "2023년 2월 7일")
    private String publishDate;

}

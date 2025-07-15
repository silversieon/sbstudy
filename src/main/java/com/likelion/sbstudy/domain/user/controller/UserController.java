package com.likelion.sbstudy.domain.user.controller;

import com.likelion.sbstudy.domain.user.dto.request.SignUpRequest;
import com.likelion.sbstudy.domain.user.dto.response.SignUpResponse;
import com.likelion.sbstudy.domain.user.entity.User;
import com.likelion.sbstudy.domain.user.service.UserService;
import com.likelion.sbstudy.global.response.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
@Tag(name = "User", description = "User 관리 API")
public class UserController {

  private final UserService userService;

  @Operation(summary = "회원가입 API", description = "사용자 회원가입을 위한 API")
  @PostMapping("/sign-up")
  public ResponseEntity<BaseResponse<SignUpResponse>> signUp(
      @RequestBody @Valid SignUpRequest signUpRequest) {
    SignUpResponse signUpResponse = userService.signUp(signUpRequest);
    return ResponseEntity.ok(BaseResponse.success("회원가입에 성공했습니다.", signUpResponse));
  }

  @Operation(summary = "회원 전체 조회", description = "회원 목록 볼 때 사용하는 API")
  @GetMapping("/list")
  public ResponseEntity<BaseResponse<List<User>>> list() {
    return ResponseEntity.ok(BaseResponse.success("모든 회원 조회 완료.", List.of()));
  }
}

package com.min9805.swagger.controller;

import com.min9805.swagger.dto.SwaggerDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2/user")
@Tag(name = "UserController", description = "그룹 API")
public class SwaggerUserController {

    @GetMapping("/userApi1")
    public String userApi1() {
        return "index";
    }

    @GetMapping("/userApi2")
    public String userApi2() {
        return "hello";
    }

    @GetMapping("/userApi3")
    public SwaggerDto userApi3() {
        return new SwaggerDto("min9805", 25);
    }

    @PostMapping("/userApi4")
    @Operation(summary = "userAPI4", description = "SwaggerDto 를 사용한 예시 API 입니다")
    public String userApi4(@RequestBody SwaggerDto swaggerDto) {
        return swaggerDto.getName();
    }
}

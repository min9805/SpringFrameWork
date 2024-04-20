package com.min9805.swagger.controller;

import com.min9805.swagger.dto.SwaggerDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/user")
@Tag(name = "BoardController", description = "게시판 API")
public class SwaggerBoardController {

    @GetMapping("/boardApi1")
    public String boardApi1() {
        return "index";
    }

    @GetMapping("/boardApi2")
    @Operation(summary = "hello API", description = "hello API 입니다.", tags = "GroupController")
    public String boardApi2() {
        return "hello";
    }
    @GetMapping("/boardApi3")
    @Operation(summary = "world API", description = "world API 입니다.", tags = "UserController")
    public String boardApi3() {
        return "world";
    }
}



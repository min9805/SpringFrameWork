package com.min9805.swagger.controller;

import com.min9805.swagger.dto.SwaggerDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

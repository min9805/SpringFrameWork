package com.min9805.swagger.controller;

import com.min9805.swagger.dto.SwaggerDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/group")
@Tag(name = "GroupController", description = "그룹 API")
public class SwaggerGroupController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/dto")
    public SwaggerDto swaggerDto() {
        return new SwaggerDto("min9805", 25);
    }
}

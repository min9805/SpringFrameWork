package com.min9805.swagger.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Tag(name = "SwaggerDto", description = "SwaggerDto API")
public class SwaggerDto {
    @Schema(title = "이름", description = "이름을 작성", example = "min9805")
    private String name;

    @Schema(title = "나이", description = "나이를 작성", example = "27")
    private int age;
}

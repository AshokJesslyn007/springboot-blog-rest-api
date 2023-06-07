package com.springboot.blog.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class PostDto {
    @NotEmpty
    private String title;

    @NotEmpty
    private String description;

    @NotEmpty
    private String content;
}

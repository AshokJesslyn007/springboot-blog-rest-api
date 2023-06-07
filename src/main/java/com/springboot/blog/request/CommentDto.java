package com.springboot.blog.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class CommentDto {
    @NotEmpty
    private String name;

    @NotEmpty
    private String emailId;

    @NotEmpty
    private String body;

}

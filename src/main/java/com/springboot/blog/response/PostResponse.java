package com.springboot.blog.response;

import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class PostResponse {
    private long id;
    private String title;
    private String description;
    private String content;
}

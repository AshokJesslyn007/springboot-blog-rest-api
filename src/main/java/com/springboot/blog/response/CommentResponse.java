package com.springboot.blog.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CommentResponse {
    private long id;
    private String name;
    private String emailId;
    private String body;
    
}

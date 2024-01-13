package com.test.api.domain;

import lombok.Data;

@Data
public class Story {
    private Long id;
    private String title;
    private String content;
    private String author;
}

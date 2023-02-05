package com.jsplib.users.book.dao;

import lombok.Getter;

@Getter
public class BookEntity {
    private Long idx;
    private String title;
    private String isbn;
    private String author;
    private String yearIssue;
    private String thumbnailUrl;
}

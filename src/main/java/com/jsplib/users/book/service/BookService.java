package com.jsplib.users.book.service;

import com.jsplib.users.book.dao.BookEntity;
import com.jsplib.users.book.dao.BookMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookMapper bookMapper;

    public BookService(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    public List<BookEntity> selectBookList() {
        return bookMapper.selectBookList();
    }
}

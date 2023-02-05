package com.jsplib.users.book.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {
    public List<BookEntity> selectBookList();
}

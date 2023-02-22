package com.jsplib.users.book.web;

import com.jsplib.users.book.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bkTestService) {
        this.bookService = bkTestService;
    }

    @GetMapping("/list")
    public String getBookListPage(Model model) {
        model.addAttribute("list", bookService.selectBookList());
        return "book/list";
    }
}

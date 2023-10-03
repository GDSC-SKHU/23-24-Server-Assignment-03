package com.example.gdsc_hw03.controller;
import com.example.gdsc_hw03.domain.Book;
import com.example.gdsc_hw03.dto.BookDto;
import com.example.gdsc_hw03.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class BookController {

    private final BookService bookService;

    // 의존성 생성자 주입
    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @PostMapping("books") // 책 저장
    public void save(@RequestBody BookDto bookDto){
        bookService.saveBook(bookDto);
    }

    @GetMapping("books/{id}") // 책 id로 조회
    public BookDto findBookById(@PathVariable Long id){
        return bookService.findBookById(id);
    }


    @GetMapping("books/{name}") // 책 name으로 조회
    public BookDto findBookByName(@PathVariable String name){
        return bookService.findBookById(Long.valueOf(name));
    }

    @GetMapping("books") // 책 전체조회
    public List<BookDto> findAllBook(){
        return bookService.findAllBook();
    }

    @PatchMapping("books/{id}") // 책 수정
    public void updateBookById(@PathVariable Long id, @RequestBody BookDto BookDto){
        bookService.updateBookById(id, BookDto);
    }


    @DeleteMapping("books/{id}") // 책 삭제
    public void deleteBookById(@PathVariable Long id){
        bookService.deleteBookById(id);
    }

}

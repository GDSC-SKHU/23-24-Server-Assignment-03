package com.example.gdsc_hw03.repository;
import com.example.gdsc_hw03.domain.Book;

import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class MemoryBookRepository implements BookRepository { // MemoryBookRepository가 BookRepository의 상속을 받음

    private static Map<Long, Book> bookstore = new HashMap<>();
    private static Long sequence = 0L; // id를 생성하기 위한 sequence

    @Override
    public void save(Book book) { // 책 저장
        book.initId(++sequence); // id를 생성하고 book에 저장
        bookstore.put(book.getId(), book); // bookstore에 저장
    }

    @Override
    public Book findById(Long id) { // 책 찾기
        return bookstore.get(id); // id에 해당하는 book을 찾아서 리턴
    }

    @Override
    public Book findByName(String name) { // 책 찾기
        return bookstore.values().stream().filter(book -> book.getName().equals(name)).findFirst().orElse(null);
                 // name에 해당하는 book을 찾아서 리턴
    }
    @Override
    public List<Book> findAll() { // 책 전체조회
        return bookstore.values().stream().toList(); //bookstore에 있는 모든 값을 리스트에 담아서 리턴
    }

    @Override
    public void updateById(Long id, Book book) { // 책 수정
        bookstore.put(id, book); //bookstore에 저장
    }

    @Override
    public void deleteById(Long id) { // 책 삭제
        bookstore.remove(id); // id에 해당하는 book을 삭제
    }

}

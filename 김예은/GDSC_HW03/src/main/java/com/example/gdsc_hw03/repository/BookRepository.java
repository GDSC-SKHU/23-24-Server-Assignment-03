package com.example.gdsc_hw03.repository;

import com.example.gdsc_hw03.domain.Book;


import java.util.List;
public interface BookRepository {
    void save(Book book);
    Book findById(Long id);

    Book findByName(String name);
    List<Book> findAll();
    void updateById(Long id, Book book);
    void deleteById(Long id);
}

package com.example.gdsc_hw03.service;
import java.util.List;

import com.example.gdsc_hw03.domain.Book;
import com.example.gdsc_hw03.dto.BookDto;
import com.example.gdsc_hw03.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) { // 의존성 생성자 주입
        this.bookRepository = bookRepository;
    }


    public void saveBook(BookDto bookDto) { // 책 저장 메소드
        Book book = Book.builder()
                .name(bookDto.getName())
                .count(bookDto.getCount())
                .build();

        bookRepository.save(book); // BookRepository를 통해 book을 저장
    }

    public BookDto findBookById(Long id) { // 책 찾기 메서드(id로 조회)
        Book book = bookRepository.findById(id); // bookRepository를 통해 id에 해당하는 book을 찾아서 반환

        return BookDto.builder()
                .id(book.getId())
                .name(book.getName())
                .count(book.getCount())
                .build(); // BookDto 반환
    }

    public BookDto findBookByName(String name) { // 책 찾기 메서드(name로 조회)
        Book book = bookRepository.findByName(name); // bookRepository를 통해 name에 해당하는 book을 찾아서 반환

        return BookDto.builder()
                .id(book.getId())
                .name(book.getName())
                .count(book.getCount())
                .build(); // BookDto 반환
    }


    public List<BookDto> findAllBook() { // 책 전체조회 메서드
        return bookRepository.findAll()
                .stream()
                .map(book -> BookDto.builder()
                        .id(book.getId())
                        .name(book.getName())
                        .count(book.getCount())
                        .build())
                .toList(); //bookRepository를 통해 모든 book을 찾아서 리턴
    }


    public void updateBookById(Long id, BookDto bookDto) { // 책 수정 메서드
        Book findBook = bookRepository.findById(id); //bookRepository를 통해 id에 해당하는 book을 찾아서 리턴
        findBook.updateBook(bookDto.getName(), bookDto.getCount()); //book 내용 수정

        bookRepository.updateById(id, findBook); // bookRepository를 통해 id에 해당하는 book을 찾아서 내용을 수정
    }

    public void deleteBookById(Long id) { // 책 삭제 메서드
        bookRepository.deleteById(id); // BookRepository를 통해 id에 해당하는 book을 찾아서 삭제
    }
}

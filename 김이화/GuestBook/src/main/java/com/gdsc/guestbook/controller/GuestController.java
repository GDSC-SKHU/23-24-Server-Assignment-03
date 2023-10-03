package com.gdsc.guestbook.controller;

import com.gdsc.guestbook.dto.GuestDto;
import com.gdsc.guestbook.service.GuestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// @RestController : @Controller + @ResponseBody
// @Controller : Spring Web MVC에서 view에 데이터 전달
// @ResponseBody : 반환값 JSON 형식으로 변환하여 HTTP 응답 본문 전송
@RestController
public class GuestController {

    private final GuestService guestService;

    // 의존성 생성자 주입
    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    @PostMapping("guests")
    public void insert(@RequestBody GuestDto guestDto) { // @RequestBody : HTTP 요청의 본문(JSON)을 자바 객체로 변환
        guestService.insertGuest(guestDto);
    }

    @GetMapping("guests/{id}")
    public GuestDto findGuestById(@PathVariable Long id) { // PathVariable : URL 변수를 넣을 수 있게 해줌
        return guestService.findGuestById(id);
    }

    @GetMapping("guests")
    public List<GuestDto> findAllGuest() {
        return guestService.findAllGuest();
    }

    @PatchMapping("guests/{id}")
    public void updateGuestById(@PathVariable Long id, @RequestBody GuestDto guestDto) {
        guestService.updateGuestById(id, guestDto);
    }

    @DeleteMapping("guests/{id}")
    public void deleteGuestById(@PathVariable Long id) {
        guestService.deleteGuestById(id);
    }

}

package com.example.myproject.controller;

import com.example.myproject.dto.MemberDto;
import com.example.myproject.service.MemberService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemberController {

    private final MemberService memberService;

    // 의존성 생성자 주입
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // POST 요청을 처리하여 회원 정보를 저장.
    @PostMapping("members")
    public void save(@RequestBody MemberDto memberDto) {
        memberService.saveMember(memberDto);
    }

    // GET 요청을 처리하여 특정 ID의 회원 정보를 조회.
    @GetMapping("members/{id}")
    public MemberDto findMemberById(@PathVariable Long id) {
        return memberService.findMemberById(id);
    }

    // GET 요청을 처리하여 모든 회원 정보를 조회.
    @GetMapping("members")
    public List<MemberDto> findAllMember() {
        return memberService.findAllMember();
    }

    // PATCH 요청을 처리하여 특정 ID의 회원 정보를 업데이트.
    @PatchMapping("members/{id}")
    public void updateMemberById(@PathVariable Long id, @RequestBody MemberDto memberDto) {
        memberService.updateMemberById(id, memberDto);
    }

    // DELETE 요청을 처리하여 특정 ID의 회원 정보를 삭제.
    @DeleteMapping("members/{id}")
    public void deleteMemberById(@PathVariable Long id) {
        memberService.deleteMemberById(id);
    }

}

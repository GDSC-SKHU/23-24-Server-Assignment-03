package com.gdsc.gymdata.controller;

import com.gdsc.gymdata.dto.MemberDto;
import com.gdsc.gymdata.service.MemberService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemberController {

    private final MemberService memberService;

    // 의존성 생성자 주입
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("members")
    // @RequestBody -HTTP 요청의 본문(json)을 자바 객체로 변환
    public void save(@RequestBody MemberDto memberDto) {
        memberService.saveMember(memberDto);
    }

    @GetMapping("members/{id}")
    // @PathVariable -URI에 변수 삽입
    public MemberDto findMemberById(@PathVariable Long id) {
        return memberService.findMemberById(id);
    }

    @GetMapping("members")
    public List<MemberDto> findAllMember() {
        return memberService.findAllMember();
    }

    @PatchMapping("members/{id}")
    public void updateMemberById(@PathVariable Long id, @RequestBody MemberDto memberDto) {
        memberService.updateMemberById(id, memberDto);
    }

    @DeleteMapping ("members/{id}")
    public void deleteMemberById(@PathVariable Long id) {
        memberService.deleteMemberById(id);
    }
}

package com.gdsc.pcbangmembershipmanagement.controller;

import com.gdsc.pcbangmembershipmanagement.dto.MemberDto;
import com.gdsc.pcbangmembershipmanagement.service.MemberService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemberController {
    private final MemberService memberService;

    // 의존성 생존자 주입
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("members")  // 계정 생성
    public void createAccount(@RequestBody MemberDto memberDto) {
        memberService.createAccount(memberDto);
    }

    @GetMapping("members/{id}")  // 한 개의 아이디 조회
    public MemberDto findNameById(@PathVariable String id){
        return memberService.findNameById(id);
    }

    @GetMapping("members/list")  // 모든 아이디 조회
    public List<MemberDto> findAllId(){
        return memberService.findAllId();
    }

    @PatchMapping("members/{id}")  // 회원 정보 수정
    public void updateById(@PathVariable String id, @RequestBody MemberDto memberDto){
        memberService.updateById(id, memberDto);
    }

    @DeleteMapping("members/{id}")  // 아이디 삭제
    public void deleteIdByID(@PathVariable String id) {
        memberService.deleteIdById(id);
    }
}

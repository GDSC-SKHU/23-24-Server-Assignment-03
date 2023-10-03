package com.gdsc.membershipmanagement.controller;

import com.gdsc.membershipmanagement.dto.MemberManagementDto;
import com.gdsc.membershipmanagement.service.MemberManagementService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemberManagementController {

    private final MemberManagementService mmService;

    public MemberManagementController(MemberManagementService mmService){
        this.mmService = mmService;
    }

    @PostMapping("memberdatas") // 새로운 사용자의 id와 password를 입력받으면 저장
    public void saveMemberManagement (@RequestBody MemberManagementDto membermanagementDto){
        mmService.saveMemberManagement(membermanagementDto);
    }

    @GetMapping("memberdatas/{id}") // id를 입력받아 해당하는 사용자의 userid와 userpassword를 출력
    public MemberManagementDto findMemberManagementById(@PathVariable Long id){
        return mmService.findMemberManagementById(id);
    }

    @GetMapping("memberdatas") // 전체 회원 조회
    public List<MemberManagementDto> findAllMemberManagement(){
        return mmService.findAllMemberManagement();
    }

    @PatchMapping("memberdatas/{id}") // id를 통해서 userid와 userpassword를 입력받아 해당 id의 user id와 password수정
    public void updateMemberManagementById(@PathVariable Long id, @RequestBody MemberManagementDto membermanagementDto){
        mmService.updateMemberManagementById(id, membermanagementDto);
    }

    @DeleteMapping("memberdatas/{id}") // id를 입력받아 해당 id 삭제
    public void deleteMemberManagementById(@PathVariable Long id){
        mmService.deleteMemberManagementById(id);
    }

}

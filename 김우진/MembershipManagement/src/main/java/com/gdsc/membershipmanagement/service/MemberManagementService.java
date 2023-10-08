package com.gdsc.membershipmanagement.service;


import com.gdsc.membershipmanagement.domain.MemberManagement;
import com.gdsc.membershipmanagement.dto.MemberManagementDto;
import com.gdsc.membershipmanagement.repository.MemberManagementRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberManagementService {

    private final MemberManagementRepository mmRepository;

    //의존성 생성자 주입
    public MemberManagementService(MemberManagementRepository mmRepository){ //의존성 생성자 주입
        this.mmRepository = mmRepository;
    }

    public void saveMemberManagement(MemberManagementDto membermanagementDto){
        MemberManagement memberdate = membermanagementDto.toEntity();

        mmRepository.save(memberdate); //mmRepository를 통해서 memberdata를 저장
    }

    public MemberManagementDto findMemberManagementById(Long id){
        // mmRepository를 통해 id에 해당하는 멤버 정보를 반환
        MemberManagement memberdate = mmRepository.findById(id);

        return MemberManagementDto.builder()
                .id(memberdate.getId())
                .userid(memberdate.getUserid())
                .userpassword(memberdate.getUserpassword())
                .build();
    }

    public List<MemberManagementDto> findAllMemberManagement(){
        return mmRepository.findAll()
                .stream()
                .map(mmRepository -> {
                    return MemberManagementDto.builder()
                            .id(mmRepository.getId())
                            .userid(mmRepository.getUserid())
                            .userpassword(mmRepository.getUserpassword())
                            .build();
                })
                .toList(); //mmRepository를 통해서 모든 멤버들의 id, userid, userpassword를 찾아서 반환
    }
    public void updateMemberManagementById(Long id, MemberManagementDto membermanagementDto){
        MemberManagement memberData = membermanagementDto.toEntity(); //memeberData를 통해서 해당하는 id, userid, userpassword를 반환
        memberData.initId(id);

        mmRepository.updateById(id, memberData); //mmRepository를 통해서 해당하는 id의 memberData를 찾아서 수정
    }

    public void deleteMemberManagementById(Long id){
        mmRepository.deleteById(id); // mmRepository를 통해서 해당하는 id의 userid와 userpassword 삭제
    }
}

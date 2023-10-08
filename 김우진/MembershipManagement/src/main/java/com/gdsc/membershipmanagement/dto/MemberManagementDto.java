package com.gdsc.membershipmanagement.dto;

import com.gdsc.membershipmanagement.domain.MemberManagement;
import lombok.Builder;
import lombok.Data;

@Data
public class MemberManagementDto {
    private Long id;
    private String userid;
    private String userpassword;

    @Builder
    public MemberManagementDto(Long id, String userid, String userpassword){
        this.id = id;
        this.userid = userid;
        this.userpassword = userpassword;
    }
    public MemberManagement toEntity(){
        return MemberManagement.builder()
                .id(id)
                .userid(userid)
                .userpassword(userpassword)
                .build();
    }
}

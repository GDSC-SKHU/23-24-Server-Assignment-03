package com.gdsc.pcbangmembershipmanagement.service;

import com.gdsc.pcbangmembershipmanagement.domain.Member;
import com.gdsc.pcbangmembershipmanagement.dto.MemberDto;
import com.gdsc.pcbangmembershipmanagement.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void createAccount(MemberDto memberDto) {  // 계정 생성
        Member member = memberDto.toEntity();
        memberRepository.createAccount(member);
    }
    public MemberDto findNameById(String id) {  // id를 입력하면 회원정보를 보여주는 메소드(비밀번호는 노출되면 안되므로 제외)
        Member member = memberRepository.findById(id);

        return MemberDto.builder()
                .id(member.getId())
                .pw("보안 규정상 접근할 수 없습니다.")  // 비밀번호는 조회 불가
                .name(member.getName())
                .birthYear(member.getBirthYear())
                .build();
    }
    public List<MemberDto> findAllId() {   // 아이디를 조회하여 회원 정보 구하기, 비밀번호는 알 수 없음
        return memberRepository.findAllId()
                .stream()
                .map(member -> MemberDto.builder()
                        .id(member.getId())
                        .pw("보안 규정상 접근할 수 없습니다.")  // 비밀번호는 조회 불가
                        .name(member.getName())
                        .birthYear(member.getBirthYear())
                        .build())
                .toList();
    }
    public void updateById(String id, MemberDto memberDto) {  // 회원 정보 수정
        Member member = memberDto.toEntity();
        member.initId(id);
        memberRepository.updateById(id, member);  // memberRepository를 통해 id에 해당하는 member 찾아서 수정
    }
    public void deleteIdById(String id) {
        memberRepository.deleteById(id);  // 입력받은 아이디 삭제
    }
}

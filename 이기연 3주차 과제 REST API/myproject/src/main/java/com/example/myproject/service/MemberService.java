package com.example.myproject.service;

import com.example.myproject.domain.Member;
import com.example.myproject.dto.MemberDto;
import com.example.myproject.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    // 회원 관련 비즈니스 로직을 처리하는 서비스 클래스

    // 회원 리포지토리에 대한 의존성 주입
    private final MemberRepository memberRepository;

    // 테스트용 메소드
    void test() {
        System.out.println(Math.abs(-30));
    }

    // 의존성 생성자 주입
    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    // 회원 정보를 저장하는 메소드
    public void saveMember(MemberDto memberDto) {
        Member member = Member.builder()
                .name(memberDto.getName())
                .phone_number(memberDto.getPhone_number())
                .build();

        memberRepository.save(member); // 회원 리포지토리를 통해 회원 정보를 저장
    }

    // 특정 ID에 해당하는 회원 정보를 조회하는 메소드
    public MemberDto findMemberById(Long id) {
        Member member = memberRepository.findById(id); // 회원 리포지토리를 통해 ID에 해당하는 회원 정보를 찾아서 반환

        return MemberDto.builder()
                .id(member.getId())
                .name(member.getName())
                .phone_number(member.getPhone_number())
                .build(); // 회원 정보를 회원 DTO로 변환하여 반환
    }

    // 모든 회원 정보를 조회하는 메소드
    public List<MemberDto> findAllMember() {
        return memberRepository.findAll()
                .stream()
                .map(member -> MemberDto.builder()
                        .id(member.getId())
                        .name(member.getName())
                        .phone_number(member.getPhone_number())
                        .build())
                .toList(); // 회원 리포지토리를 통해 모든 회원 정보를 찾아서 회원 DTO 리스트로 변환하여 반환
    }

    // 특정 ID에 해당하는 회원 정보를 업데이트하는 메소드
    public void updateMemberById(Long id, MemberDto memberDto) {
        Member findMember = memberRepository.findById(id); // 회원 리포지토리를 통해 ID에 해당하는 회원 정보를 찾아서 반환
        findMember.updateMember(memberDto.getName(), memberDto.getPhone_number()); // 회원 정보를 업데이트

        memberRepository.updateById(id, findMember); // 회원 리포지토리를 통해 ID에 해당하는 회원 정보를 업데이트
    }

    // 특정 ID에 해당하는 회원 정보를 삭제하는 메소드
    public void deleteMemberById(Long id) {
        memberRepository.deleteById(id); // 회원 리포지토리를 통해 ID에 해당하는 회원 정보를 삭제
    }

}

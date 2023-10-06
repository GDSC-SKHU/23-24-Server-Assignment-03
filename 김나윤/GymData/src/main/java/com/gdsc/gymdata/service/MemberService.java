package com.gdsc.gymdata.service;

import com.gdsc.gymdata.domain.Member;
import com.gdsc.gymdata.dto.MemberDto;
import com.gdsc.gymdata.repository.MemberRepository;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    /* 의존성 생성자 주입
    -NullPointerException 방지
    -순환참조 방지
    -final로 객체 변경 방지
     */
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void saveMember(MemberDto memberDto) {
        Member member = Member.builder()
                .name(memberDto.getName())
                .height(memberDto.getHeight())
                .weight(memberDto.getWeight())
                .build();

        // memberRepository를 통해 member 저장
        memberRepository.save(member);
    }

    public MemberDto findMemberById(Long id) {
        // id에 해당하는 member 반환
        Member member = memberRepository.findById(id);

        return MemberDto.builder()
                .id(member.getId())
                .name(member.getName())
                .height(member.getHeight())
                .weight(member.getWeight())
                .build();
    }

    public List<MemberDto> findAllMember() {
        // 모든 member 요소를 반환
        return memberRepository.findAll()
                .stream()
                .map(member -> MemberDto.builder()
                    .id(member.getId())
                    .name(member.getName())
                    .height(member.getHeight())
                    .weight(member.getWeight())
                    .build())
                .toList();
    }

    public void updateMemberById(Long id, MemberDto memberDto) {

        Member findMember = memberRepository.findById(id);
        findMember.updateMember(memberDto.getName(), memberDto.getHeight(), memberDto.getWeight());

        memberRepository.updateById(id, findMember);
    }

    public void deleteMemberById(Long id) {
        memberRepository.deleteById(id);
    }

}

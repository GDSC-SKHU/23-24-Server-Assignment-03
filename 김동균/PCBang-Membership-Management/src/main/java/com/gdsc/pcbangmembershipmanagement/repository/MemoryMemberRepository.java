package com.gdsc.pcbangmembershipmanagement.repository;

import com.gdsc.pcbangmembershipmanagement.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemoryMemberRepository implements MemberRepository{
    private static Map<String,Member> account = new HashMap<>();

    @Override
    public void createAccount(Member member) {
        account.put(member.getId(), member);  // 입력받은 정보를 account에 저장
    }

    @Override
    public Member findById(String id) {
        return account.get(id);  // 아이디에 해당하는 value 조회
    }

    @Override
    public List<Member> findAllId() {  // 맵에 저장된 모든 id와 이름을 리턴하는 메소드 (이름 오름차순)
        return account.values().stream().sorted(Comparator.comparing(Member::getName)).toList(); // store에 있는 모든 value를 ArrayList에 담아서 반환;
    }

    @Override
    public void updateById(String id, Member member) { // 회원 정보 수정
        account.put(id, member);
    }

    @Override
    public void deleteById(String id) {
        account.remove(id);  // 해당 id 삭제
    }
}

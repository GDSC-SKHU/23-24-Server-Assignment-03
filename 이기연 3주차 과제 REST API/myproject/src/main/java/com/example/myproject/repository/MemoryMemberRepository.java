package com.example.myproject.repository;

import com.example.myproject.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemoryMemberRepository implements MemberRepository {

    // 회원 정보를 저장하는 HashMap
    private static Map<Long, Member> store = new HashMap<>();

    // 회원의 고유 식별자(id)를 생성하기 위한 sequence
    private static Long sequence = 0L;

    @Override
    // 회원 정보를 저장하는 메소드
    public void save(Member member) {
        member.initId(++sequence); // id를 생성하고 item에 저장
        store.put(member.getId(), member); // store에 저장
    }

    @Override
    // 특정 ID에 해당하는 회원 정보를 조회하는 메소드
    public Member findById(Long id) {
        return store.get(id); // id에 해당하는 item을 찾아서 반환
    }

    @Override
    // 모든 회원 정보를 조회하는 메소드
    public List<Member> findAll() {
        return store.values().stream().toList();
        // store에 있는 모든 value를 ArrayList에 담아서 반환
    }

    @Override
    // 특정 ID에 해당하는 회원 정보를 업데이트하는 메소드
    public void updateById(Long id, Member member) {
        store.put(id, member); // store에 저장, hash map은 key가 같으면 덮어씌워지기 때문에 id는 그대로 두고 내용만 수정
    }

    @Override
    // 특정 ID에 해당하는 회원 정보를 삭제하는 메소드
    public void deleteById(Long id) {
        store.remove(id); // id에 해당하는 item을 찾아서 삭제
    }

}

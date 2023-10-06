package com.gdsc.gymdata.repository;

import com.gdsc.gymdata.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemoryMemberRepository implements MemberRepository {

    /* HashMap
    -key와 value로 데이터 보관
    -key는 맵에 유일하게 존재 (null 허용)
     */
    private static Map<Long, Member> gym = new HashMap<>();
    // id 생성위한 변수 생성
    private static Long sequence = 0L;

    @Override
    public void save(Member member) {
        member.initId(++sequence);
        gym.put(member.getId(), member);
    }

    @Override
    public Member findById(Long id) {
        return gym.get(id);
    }

    @Override
    // store의 모든 value를 ArrayList로 반환
    public List<Member> findAll() {
        return gym.values().stream().toList();
    }

    @Override
    public void updateById(Long id, Member member) {
        // HashMap은 key가 같으면 덮어씌워지므로 내용만 수정함
        gym.put(id, member);
    }

    @Override
    public void deleteById(Long id) {
        gym.remove(id);
    }
}

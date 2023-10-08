package com.gdsc.membershipmanagement.repository;

import com.gdsc.membershipmanagement.domain.MemberManagement;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemoryMemberManagementRepository implements MemberManagementRepository{

    private static Map<Long, MemberManagement> memberList = new HashMap<>();
    private static Long sequence; // id생성을 위한 sequence
    static {
        sequence = 0L;
    }
    @Override
    public void save(MemberManagement memberdata) {
        memberdata.initId(++sequence); //id생성후에 memberdata에 저장 sequence는 후순위 연산으로 저장후에 하나씩 증가
        memberList.put(memberdata.getId(), memberdata); // memberList에 저장
    }

    @Override // 해당하는 id를 찾아서 반환
    public MemberManagement findById(Long id) {
        return memberList.get(id);
    }

    @Override // memberList에 있는 모든 Value를 List에 담아서 반환함
    public List<MemberManagement> findAll() {
        return memberList.values().stream().toList();
    }

    @Override // id는 그대로 유지하고 memberdata만 수정함
    public void updateById(Long id, MemberManagement memberdata) {
        memberList.put(id, memberdata);
    }

    @Override //해당하는 id를 찾아서 삭제
    public void deleteById(Long id) {
        memberList.remove(id);
    }
}

package com.gdsc.membershipmanagement.repository;

import com.gdsc.membershipmanagement.domain.MemberManagement;


import java.util.List;

public interface MemberManagementRepository{

    void save(MemberManagement memberdata);
    MemberManagement findById(Long id);
    List<MemberManagement> findAll();
    void updateById(Long id, MemberManagement memberdata);
    void deleteById(Long id);
}

package com.example.repository;

import com.example.domain.MemberDto;
import com.example.domain.MemberModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<MemberModel,Long>
{
    List<MemberModel> findMemberModelByName(String name);
    List<MemberModel>findMemberModelByDegree(String degree);

    List<MemberModel>findMemberModelByEmail(String email);

}

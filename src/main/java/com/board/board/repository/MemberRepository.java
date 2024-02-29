package com.board.board.repository;

import com.board.board.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {
    Member findByName(String name);
    Member findById(String id);
}

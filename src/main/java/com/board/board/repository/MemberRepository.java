package com.board.board.repository;

import com.board.board.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member,Long> {
    Member findByName(String name);
    boolean existsById(String id);
    /*boolean existsByNickname(String nickname);*/
    Optional<Member> findById(String id);
    Optional<Member> findByNum(Long num);
}

package com.board.board.service;

import java.util.List;

import com.board.board.DTO.MemberDTO;
import com.board.board.domain.Member;
import com.board.board.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public void CreatMember(MemberDTO memberDTO){                 //DTO -> DB
        Member saveParam = Member.builder()
                .id(memberDTO.getId())
                .pwd(memberDTO.getPwd())
                .name(memberDTO.getName())
                .build();
        this.memberRepository.save(saveParam);
//        return saveParam;
    }



}
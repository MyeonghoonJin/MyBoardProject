package com.board.board.service;

import java.util.List;
import java.util.Optional;
import com.board.board.DTO.MemberDTO;
import com.board.board.domain.Member;
import com.board.board.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
@Transactional
public class MemberService {
    private final MemberRepository memberRepository;


    public  boolean checkIdDuplicated(String id){
        return memberRepository.existsById(id);
    }


    //회원 가입 메소드
    public boolean CreatMember(MemberDTO memberDTO){                 //DTO -> DB

        Member saveParam = Member.builder()
                .id(memberDTO.getId())
                .pwd(memberDTO.getPwd())
                .name(memberDTO.getName())
                .build();


        //중복이 아니면 DB에 저장, true 반환
        if(!checkIdDuplicated(saveParam.getId())) {
            this.memberRepository.save(saveParam);
            return true;
        }
        //중복 시 false 반환
        else {
            return false;
        }
    }
    //로그인 메소드(세션 로그인)
    public Member MemberSignIn(Member member){
        Optional<Member> memberOptional = memberRepository.findById(member.getId());

        // loginId와 일치하는 User가 없으면 null return
        if(memberOptional.isEmpty()){
            return null;
        }
        //해당 User의 정보를 member에 저장
        Member member1 = memberOptional.get();

        //member의 pwd와 입력된 pwd가 다르면 null return
        if(!member1.getPwd().equals(member.getPwd())){
            return null;
        }
        return member1;
    }
    public Member getSignInMemberByNum(Long num){
        if(num == null)return null;

        Optional<Member> optionalMember = memberRepository.findByNum(num);
        if(optionalMember.isEmpty())return null;

        return optionalMember.get();
    }



}
//package com.board.board.service;
//
//import com.board.board.domain.Member;
//import com.board.board.repository.MemberRepository;
//import com.board.board.usecase.LoginService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//public class LoginServiceImpl implements LoginService {
//
//    private final MemberRepository memberRepository;
//    @Override
//    public boolean isAccess() {
//        Member isMember = Member.builder()
//                .id(memberId)
//                .pwd(memberPwd)
//                .build();
//        Member findMember = memberRepository.findById(memberId);
//
//        if (!findMember.getPwd().equals(isMember.getPwd())){
//            return false;
//        }
//        memberRepository.save(isMember);
//        return true;
//    }
//
//    @Override
//    public boolean isValid() {
//        return false;
//    }
//}

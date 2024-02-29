package com.board.board.service;

//import com.board.board.domain.Member;
//import com.board.board.repository.MemberRepository;
//import jakarta.validation.constraints.Null;
//import lombok.RequiredArgsConstructor;
//import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
//import org.springframework.stereotype.Service;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//import java.util.Optional;

//@RequiredArgsConstructor
//@Service
//public class MemberSecurityService implements UserDetailsService {
//    private final MemberRepository memberRepository;
//
//    @Override
//    public UserDetails loadMemberByMemberId(String id,String pwd) throws UsernameNotFoundException{
//        Member member = this.memberRepository.findById(id);                             //id를 통해 Member를 찾아봄
//        if(member == null){
//            throw new UsernameNotFoundException("사용자를 찾을수 없습니다.");               //해당 id가 없으면 예외처리
//        }
//        if(member.getPwd() == pwd){                                                     //해당 id의 pwd가 입력값과 일치하면
//
//        }
//    }
//}

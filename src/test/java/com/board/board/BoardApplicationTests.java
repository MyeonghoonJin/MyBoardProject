package com.board.board;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.board.board.domain.Member;
import com.board.board.repository.MemberRepository;



@SpringBootTest
class BoardApplicationTests {

	@Autowired
	MemberRepository memberRepository;

	//회원 생성
	@Test
//	void saveMember(){
//		Member saveParams = Member.builder()
//				.id("jtvy1234")
//				.pwd("a8211294")
//				.name("James")
//				.build();
//		Member member_domain = memberRepository.save(saveParams);
//	}
//	@Test
//	void findAllMember(){
//		memberRepository.findAll();
//	}
	void contextLoads() {
		System.out.println();
	}

}

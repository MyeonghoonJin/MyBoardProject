package com.board.board.controller;

import com.board.board.DTO.MemberDTO;
import com.board.board.DTO.PostDTO;
import com.board.board.domain.Enum.BoardType;
import com.board.board.domain.Member;
import com.board.board.repository.MemberRepository;
import com.board.board.service.MemberService;
import com.board.board.service.PostService;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.ui.Model;

import com.board.board.domain.Post;
import com.board.board.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@org.springframework.stereotype.Controller
public class Controller {
  private final MemberRepository memberRepository;
  private final MemberService memberService;
  private final PostRepository postRepository;
  private final PostService postService;

    //root URL
    @GetMapping("/")
    public String root() {
      return "redirect:homepage";
    }

    //Homepage
    @GetMapping("homepage")
    public String homepage(Model model,@SessionAttribute(name = "num" ,required = false)Long num){

      Member signInMeber = memberService.getSignInMemberByNum(num);

      if(signInMeber != null){
        model.addAttribute("id",signInMeber.getId());
      }

      List<Post> FreeBoard = postService.getPostByBoardType(BoardType.FREE);
      model.addAttribute("Free",FreeBoard);
      List<Post> SecretBoard = postService.getPostByBoardType(BoardType.SECRET);
      model.addAttribute("Secret",SecretBoard);
      List<Post> DeepnoidBoard = postService.getPostByBoardType(BoardType.DEEPNOID);
      model.addAttribute("Deepnoid",DeepnoidBoard);
      List<Post> InfoBoard = postService.getPostByBoardType(BoardType.INFORMATION);
      model.addAttribute("Information",InfoBoard);
      List<Post> DebateBoard = postService.getPostByBoardType(BoardType.DEBATE);
      model.addAttribute("Debate",DebateBoard);
      List<Post> QuestionBoard = postService.getPostByBoardType(BoardType.QUESTION);

      model.addAttribute("Question",QuestionBoard);
      return "homepage";
    }
    //SignUp 페이지 요청
    @GetMapping("SignUp")
    public String SignUp(){
      return "SignUp";
    }

    //SignUp(회원가입)을 눌렀을 때 동작 요청
    @PostMapping("SignUp")
    public String SaveMember(@RequestParam("id") String id,@RequestParam("pwd") String pwd,@RequestParam("name") String name,@RequestBody String str,BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
        //Error 발생 시 페이지 새로고침
        return "SignUp";
      }
      //입력받은 정보들을 memberDTO에 저장
      MemberDTO memberDTO = new MemberDTO();
      memberDTO.setId(id);
      memberDTO.setPwd(pwd);
      memberDTO.setName(name);

      //가입 성공 시 홈페이지로 이동
      if(memberService.CreatMember(memberDTO)){
        return "redirect:/";
      }
      //가입 실패 시(중복 아이디)
      else {
        bindingResult.reject("DuplicatedId","이미 존재하는 아이디입니다.");
        return "SignUp";
      }
    }

  //SignIn 페이지 요청 시
  @GetMapping("SignIn")
  public String SignIn(Model model){
    model.addAttribute("SignInRequest",new Member());
    return "SignIn";
  }
  //SignIn 시 동작
  @PostMapping("SignIn")
  public String SignIn(@Valid @ModelAttribute("SignInRequest") Member signInRequest,
                       BindingResult bindingResult,
                       HttpServletRequest httpServletRequest,
                       Model model){

    Member member = memberService.MemberSignIn(signInRequest);

    //검증 오류가 있는 지 먼저 확인
    if(bindingResult.hasErrors()){
      return  "SignIn";
    }

    if(member == null){
      bindingResult.reject("SignInError","아이디 또는 비밀번호가 틀렸습니다.");
      return "SignIn";
    }


    //로그인 성공 시

    //기존 세션 파기
    httpServletRequest.getSession().invalidate();
    HttpSession session = httpServletRequest.getSession(true);
    //세션 아이디 설정
    session.setAttribute("num",member.getNum());
    //세션 유지 기간 : 30분

    session.setMaxInactiveInterval(1800);

      return "redirect:/";
  }
  @GetMapping("/LogOut")
  public String logout(HttpServletRequest request){
      HttpSession session = request.getSession(false);
      if(session != null){
        session.invalidate();
      }

      return "redirect:/";
  }
  @GetMapping("/SignInFailed")
  public String SignInFailed(){
      return "SignIn";
  }
}



package com.board.board.controller;

import com.board.board.DTO.MemberDTO;
import com.board.board.domain.Enum.BoardType;
import com.board.board.repository.MemberRepository;
import com.board.board.service.MemberService;
import com.board.board.service.PostService;
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


    @GetMapping("/")                                   //root URL
    public String root() {
      return "redirect:homepage";
    }

    @GetMapping("homepage")                            //Homepage
    public String homepage(Model model){

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
    @GetMapping("SignUp")
    public String SignUp(){
      return "SignUp";
    }
    @PostMapping("SignUp")
    public String SaveMember(@RequestParam("id") String id,@RequestParam("pwd") String pwd,@RequestParam("name") String name,@RequestBody String str,BindingResult bindingResult){
      if(bindingResult.hasErrors()) {
        return "SignUp";
      }
      MemberDTO memberDTO = new MemberDTO();
      memberDTO.setId(id);
      memberDTO.setPwd(pwd);
      memberDTO.setName(name);

      memberService.CreatMember(memberDTO);
      return "redirect:/";
    }
  @GetMapping("SignIn")
  public String SignIn(Model model){

    return "SignIn";
  }
  @PostMapping("SignIn")
  public String SignIn(){

      return "redirect:/";
  }

}



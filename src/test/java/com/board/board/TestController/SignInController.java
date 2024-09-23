package com.board.board.TestController;


import com.board.board.usecase.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/session-login")
public class SignInController {
    private final LoginService loginService;

    @GetMapping("/test")
    public void test(){
        return loginService.isAccess();
    }
}

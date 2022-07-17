package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberService memberService;

    // memberService를 spring이 spring container에 있는 memeberService를 연결해준다.

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}

package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService;

    // memberService를 spring이 spring container에 있는 memeberService를 연결해준다.

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // GetMapping - url 치는 것, 조회할 때 사용
    @GetMapping("/members/new")
    public String createForm() {
        // templates에서 찾는다.
        return "members/createMemberForm";
    }

    // PostMapping - 데이터를 폼에 넣어서 전달, 데이터를 등록할 때 사용
    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        // 회원 가입이 잘 됐을 것이다.
        memberService.join(member);

        // 회원가입이 끝난 후 홈 화면으로 보내기
        return "redirect:/";
    }

    // 회원 목록
    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }

}

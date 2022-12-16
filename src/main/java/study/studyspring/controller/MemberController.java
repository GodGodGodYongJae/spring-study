package study.studyspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import study.studyspring.domain.Member;
import study.studyspring.service.MemberService;

import java.util.List;

@Controller
public class MemberController {
    private final MemberService memberSerivce;

    @Autowired
    public MemberController(MemberService memberSerivce) {
        this.memberSerivce = memberSerivce;
    }

    @GetMapping("/members/new")
    public String create(MemberForm form){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String createForm(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());
        memberSerivce.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model)
    {
        List<Member> members = memberSerivce.findMembers();
        model.addAttribute("members",members);
        return "members/memberlist";
    }
}

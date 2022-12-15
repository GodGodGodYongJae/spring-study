package study.studyspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import study.studyspring.service.MemberService;

@Controller
public class MemberController {
    private final MemberService memberSerivce;

    @Autowired
    public MemberController(MemberService memberSerivce) {
        this.memberSerivce = memberSerivce;
    }
}

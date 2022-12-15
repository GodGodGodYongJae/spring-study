package study.studyspring.service;

import org.junit.jupiter.api.Test;
import study.studyspring.domain.Member;

class MemberServiceTest {
     MemberService memberService = new MemberService();

     @Test
    void JoinTest(){
         Member member1 = new Member();
         member1.setName("test1");
         memberService.join(member1);
         Member member2 = new Member();
         member2.setName("test1");
         memberService.join(member2);
     }

}

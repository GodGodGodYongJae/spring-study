package study.studyspring.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import study.studyspring.domain.Member;
import study.studyspring.repository.MemberRepository;
import study.studyspring.repository.MemoryMemberRepository;

import static org.junit.jupiter.api.Assertions.assertThrows;

class MemberServiceTest {

    MemoryMemberRepository memberRepository = new MemoryMemberRepository();
    MemberService memberService = new MemberService(memberRepository);
     @AfterEach
     public void afterEach(){
         memberRepository.clearStore();
     }

     @Test
    void join(){
         //given
         Member member1 = new Member();
         member1.setName("spring");

         //when
         Long saveId = memberService.join(member1);

         //then
         Member findMemeber = memberService.findOne(saveId).get();
         Assertions.assertThat(member1.getName()).isEqualTo(findMemeber.getName());
     }

     @Test
    public void 중복_회원_예외()
     {
         //given
         Member member1 = new Member();
         member1.setName("spring");
         Member member2 = new Member();
         member2.setName("spring");
         //when
         memberService.join(member1);

         // then
         IllegalStateException e = assertThrows(IllegalStateException.class,
                 () -> memberService.join(member2));

         // 예외의 메시지도 검증 가능
         Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
     }



}

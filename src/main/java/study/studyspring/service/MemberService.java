package study.studyspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import study.studyspring.domain.Member;
import study.studyspring.repository.MemberRepository;
import study.studyspring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    private final MemberRepository memberRepository;
    @Autowired
   public MemberService(MemberRepository mr)
    {
        this.memberRepository = mr;
    }

    /**
     * 회원 가입 로직
    **/
    public Long join(Member member)
    {
        // 같은 이름이 있는 중복 회원은 제외한다.
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    // 전체회원 조회
    public List<Member> findMembers()
    {
       return memberRepository.findAll();
    }

    //단일 회원 조회
    public Optional<Member> findOne(long memberId)
    {
        return memberRepository.findById(memberId);
    }
    private void validateDuplicateMember(Member member)
    {
        memberRepository.findByName(member.getName()).ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });

    }

}

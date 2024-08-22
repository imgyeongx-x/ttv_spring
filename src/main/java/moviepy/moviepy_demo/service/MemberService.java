package moviepy.moviepy_demo.service;

import moviepy.moviepy_demo.domain.Member;
import moviepy.moviepy_demo.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional  // DB 작업이 포함된 메서드에는 트랜잭션이 필요합니다.
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Long join(Member member) {
        validateDuplicateMember(member);  // 중복된 회원인지 체크

        // 회원 정보 저장
        memberRepository.save(member);

        // 저장 후, 회원의 ID 반환
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByUserId(member.getUserId())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(String userId) {
        return memberRepository.findByUserId(userId);
    }
}

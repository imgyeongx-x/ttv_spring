package moviepy.moviepy_demo.repository;

import moviepy.moviepy_demo.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByUserId(String userId);
    Optional<Member> findByUserName(String userName);
    Optional<Member> findByPassword(String password);
}
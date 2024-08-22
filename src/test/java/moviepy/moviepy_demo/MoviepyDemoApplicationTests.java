package moviepy.moviepy_demo;

import moviepy.moviepy_demo.domain.Member;
import moviepy.moviepy_demo.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MoviepyDemoApplicationTests {

	MemberRepository memberRepository;
	@Test
	public void basicCRUD() {// MemberJpaRepository -> MemberRepository로 변경
		Member member1 = new Member();
		Member member2 = new Member();
		memberRepository.save(member1);
		memberRepository.save(member2);
	}
}

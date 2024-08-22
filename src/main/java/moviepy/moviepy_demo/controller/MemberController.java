package moviepy.moviepy_demo.controller;

import moviepy.moviepy_demo.domain.Member;
import moviepy.moviepy_demo.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")  // 리액트 클라이언트의 URL
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/signup/success")
    public ResponseEntity<String> registerUser(@RequestBody Member member) {
        try {
            // 회원 가입 서비스 호출
            Long memberId = memberService.join(member);

            // 성공 시, 가입된 회원의 ID와 함께 응답
            return ResponseEntity.ok("회원 가입 성공. ID: " + memberId);

        } catch (IllegalStateException e) {
            // 중복 회원이 있을 때 예외 처리
            return ResponseEntity.badRequest().body("이미 존재하는 회원입니다: " + e.getMessage());
        } catch (Exception e) {
            // 기타 예외 처리
            return ResponseEntity.status(500).body("회원 가입 중 오류가 발생했습니다: " + e.getMessage());
        }
    }
    
}

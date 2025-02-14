package hello.hello_spring;


import hello.hello_spring.Service.MemberService;
import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.repository.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    //스프링 빈을 직접 자바 코드로 등록하기
    //이 방법이 아니면 @Repository, @Autowired, @Service 와 같은 어노테이션을 사용해줘야 한다
    //컨트롤러는 그대로 어노테이션 사용해줘야 한다
    @Bean
    public MemberService memberService() {
        //멤버서비스 생성자에 멤버 리포지토리를 넣어줬으므로 스프링 빈을 등록할때도 멤버 리포지토리를 넣어줘야 한다
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}

package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }


    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
//        System.out.println("result = " + (result == member));

//        Assertions.assertEquals(member,result);
//        Assertions.assertThat(member).isEquals(result);
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring").get();
        Assertions.assertEquals(member1,result);
    }

    @Test
    public void findAll(){
        Member member3 = new Member();
        member3.setName("spring3");
        repository.save(member3);

        Member member4 = new Member();
        member4.setName("spring4");
        repository.save(member4);

        List<Member> result = repository.findAll();
        Assertions.assertEquals(result.size(),2);


    }
}

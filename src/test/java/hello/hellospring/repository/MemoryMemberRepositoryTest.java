package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    //각 메서드가 끝날때마다 동작하는 메서드
    //여기선 테스트 데이터 지우기용?
    //왜 지워야하냐면 이거 밑에꺼 다 테스트하는데 딴애한테 넣은 데이터 딴애가 들구 테스트면 맞아도 오류남
    //test는 의존관계 없이 설계가 되어야한다.
    @AfterEach
    public void afterEach(){
        repository.clearStore();
    };

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        //optional에서 값을 꺼낼때는 get
        Member result = repository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);

    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}

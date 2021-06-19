package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//repository : 저장소
//member 객체를 저장하는 저장소
public interface MemberRepository {
    Member save(Member member);
    //optional: null을 반환하면
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}

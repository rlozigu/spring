package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    //select m from Member m where m.name = ?
    //findBy* 의 *에 따라 알아서 쿼리를 짜준다
    @Override
    Optional<Member> findByName(String name);
}

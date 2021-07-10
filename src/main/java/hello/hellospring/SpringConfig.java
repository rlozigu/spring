package hello.hellospring;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import javax.swing.*;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    //생성자가 하나인 경우에는 @Autowired 생략가능능
   public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //    //스프링 설정파일을 보고 스프링이 자동으로 DataSource 빈을 만들어 줌
//    private DataSource dataSource;
//
//    EntityManager em;

//    @Autowired
//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }
//
//    @Autowired
//    public SpringConfig(EntityManager em) {
//        this.em = em;
//    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }

//    @Bean
//    public MemberRepository memberRepository(){
//        //return new MemoryMemberRepository();
//       // return new JdbcMemberRepository(dataSource);
//       // return new JdbcTemplateMemberRepository(dataSource);
//       // return new JpaMemberRepository(em);
//    }

}

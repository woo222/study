package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//SpringDataJpaMemberRepository 가 JpaRepository를 받고 있으면 구현체를 자동으로 만들어서 Spring Bean에 자동으로 등록해준다.
// 기본적인 CRUD를 제공해 준다.
public interface SpringDataJpaMemberRepository extends JpaRepository <Member, Long>, MemberRepository {

    // JPQL select m from Member m where m.name = ?
    @Override
    Optional<Member> findByName(String name);
}

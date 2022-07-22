package hello.hellospring.repository; // 회원 객체를 저장하는 저장소

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); // 회원을 저장하면 반환 됨
    Optional<Member> findById(Long id); // id로 회원찾기 / optional로 null을 감싸서 반환(?)
    Optional<Member> findByName(String name);
    List<Member> findAll(); // 지금까지 저장된 모든 회원 리스트를 반환한다.
}

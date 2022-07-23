package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;


public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>(); // 키는 회원 id(long), 값은 Member / 실무에선 동시성 문제 땜에 concurrentHashMap? 사용해야 함
    private static long sequence = 0L; // 0,1,2 키 값을 생성해 줌 / 실무에선 동시성 문제 해결해줘야 한다.

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); // Null이 될 가능성도 고려
    }

    @Override
    public Optional<Member> findByName(String name) { // 이름 하나라도 있으면 그냥 그거 반환
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() { // 변수는 Map인데 반환은 List 형태이다.
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}

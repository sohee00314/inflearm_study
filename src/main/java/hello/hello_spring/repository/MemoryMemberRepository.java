package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;

import java.util.*;
/**
 * 회원 관리 기능을 구현한 클래스
 * */
public class MemoryMemberRepository implements MemberRepository {
    private static Map<Long, Member> store = new HashMap<>();//회원저보를 저장할 곳
    private static long sequence = 0L;//회원 ID가 될 변수
    /**
     * 회원 등록 기능
     * */
    @Override
    public Member save(Member member) {
        member.setId(sequence++);//회원 등록될 떄마다 하나씩 증가
        store.put(member.getId(), member);
        return member;
    }
    /**
     * 회원 ID 찾기 기능
     * */
    @Override
    public Optional<Member> findById(long Id) {
        return Optional.ofNullable(store.get(Id));
    }
    /**
     * 회원 이름 찾기 기능
     * */
    @Override
    public Optional<Member> findByName(String name) {
        //맵에서 Member를 하나씩 꺼내서 이름이 같은 것을 찾아 값을 반환
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    /**
     * 회원의 이름과 ID 찾기 기능
     * */
    @Override
    public List<Member> findAll() {
        //회원 정보를 List로 반환
        return new ArrayList<>(store.values());
    }

    public void clreaStore(){
        store.clear();
    }
}

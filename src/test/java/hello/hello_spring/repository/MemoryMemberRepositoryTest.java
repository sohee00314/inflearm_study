package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

/**
 * MemoryMemberRepository 테스트 케이스
 * */
class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();
    /**
     * 테스트 하니가 끝나고 나서 repostory를 지워지는 클래스
     * 콜백 메서드
     * */
    @AfterEach
    public void afterEach() {
        repository.clreaStore();
    }
    /**
     * 등록 기능 테이스
     * */
    @Test
    public void save(){
        Member member = new Member();
        member.setName("testName");
        member = repository.save(member);
        Member result = repository.findById(member.getId()).get();
        //member가 result가 같은지 비교
        assertThat(member).isEqualTo(result);
    }
    /**
     * 이름 검색 기능 테스트
     * */
    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("testName1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("testName2");
        repository.save(member2);

        Member result = repository.findByName("testName1").get();
        assertThat(member1).isEqualTo(result);
    }
    /**
     * 회원정보 검색 기능 테스트
     * */
    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("testName1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("testName2");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result).hasSize(2);
    }
}

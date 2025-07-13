package hello.hello_spring.service;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    MemberService memberService;
    MemoryMemberRepository memoryMemberRepository;

    @BeforeEach
    public void beforeEach() {
        memoryMemberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memoryMemberRepository);
    }

    @AfterEach
    public void afterEach() {
        memoryMemberRepository.clreaStore();
    }

    @Test
    void join() {
        // given(객체를 얻어)
        Member member = new Member();
        member.setName("test1");
        //when(기능을 수행)
        Long saveId =memberService.join(member);
        //then(결과 반환)
        Member findMember = memberService.findById(saveId).get();
        assertThat(findMember.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_에외() {
        //given
        Member member1 = new Member();
        member1.setName("test1");
        Member member2 = new Member();
        member2.setName("test1");
        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다");
//        try {
//            memberService.join(member2);
//
//        } catch (IllegalStateException e) {
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다");
//        }
        //thand
    }

    @Test
    void findMembers() {
    }

    @Test
    void findById() {
    }
}
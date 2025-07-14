package hello.hello_spring.service;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
@SpringBootTest
@Transactional
class MemberServiceIntegrationTest {
    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memoryMemberRepository;

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
    }

}
package com.example.spring.jpa1.service;

import com.example.spring.jpa1.domain.Member;
import com.example.spring.jpa1.repository.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Test
    public void 회원가입() throws Exception {

        Member member = new Member();
        member.setName("kim");

        Long savedId = memberService.join(member);

        assertEquals(member, memberService.findOne(savedId));
    }

    @Test(expected = IllegalStateException.class)
    public void 중복_회원_예약() throws Exception {
        //given
        Member member1 = new Member();
        member1.setName("kim");

        Member member2 = new Member();
        member2.setName("kim");

        //when
        memberService.join(member1);
        memberService.join(member2);

//        try {
//            memberService.join(member2);
//        }catch (IllegalStateException e) {
//            return;
//        }

        //then
        fail("미션 실패");
    }
}
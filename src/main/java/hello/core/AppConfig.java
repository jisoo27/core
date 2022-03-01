package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {


    public MemberService memberService() { // 생성자를 통해 넣어주는 것 -> 생성자 주입
        // 멤버서비스 역할
        return new MemberServiceImpl(memberRepository());
    }

    private MemoryMemberRepository memberRepository() { // 멤버레파지토리 역할
        return new MemoryMemberRepository();
    }

    public OrderService orderService() { // 오더서비스 역할
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }

}

package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{
    private final MemberRepository memberRepository ;//멤버 리파지토리에서 회원 찾아야함
    private final DiscountPolicy discountPolicy ;
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }///

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findByID(memberId); // member 리포지토리에 있는 id 로 멤버를 찾아와서 저장
        int discountPrice = discountPolicy.discount(member,itemPrice); //찾아온 멤버를 매개변수로 vip 면 1000원 , 아니몀ㄴ 0 원

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}

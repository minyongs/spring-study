package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.stereotype.Component;

@Component
public class FixDiscountPolicy implements DiscountPolicy{
    private int discountFixAmount = 1000;
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){ //enum 타입은 == 쓰는게 맞음
            return discountFixAmount;
        }else {
            return 0;
        }
    }
}
//VIP 면 천원 , 아니면 할인 없어 !!
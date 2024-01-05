package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
 // rate가 무조건 먼저 선택되게 할거야 !
public class RateDiscountPolicy implements DiscountPolicy{
    private int rateDiscount = 10;
    @Override
    public int discount(Member member, int price) {


        if(member.getGrade() == Grade.VIP){
            return price * rateDiscount / 100 ;
        }else {
            return 0;
        }
    }
}

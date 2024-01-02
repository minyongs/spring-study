package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.data.redis.DataRedisTest;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {
    DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP 고객들은 10% 할인되어야 한다.")
    void discount(){
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when
         int discount = discountPolicy.discount(member,10000);

        //then
        Assertions.assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아니면 10퍼센트 할인을 받으면 안된다.")

    void discount2(){
        //given
        Member member2 = new Member(2L,"송민형",Grade.BASIC);


        //when
        int discount2 = discountPolicy.discount(member2,10000);

        //then
        Assertions.assertThat(discount2).isEqualTo(1000);
    }

}
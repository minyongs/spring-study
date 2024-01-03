package hello.core.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
public class MemoryMemberRepository implements MemberRepository{
    private static Map<Long, Member> store = new HashMap<>(); // 클래스에서만 관리
    @Override
    public void save(Member member) {
        store.put(member.getId(), member); //멤버에서 getId로 가져오고 , 옆은 멤버

    }

    @Override
    public Member findByID(Long memberId) {
        return store.get(memberId);
    }
}

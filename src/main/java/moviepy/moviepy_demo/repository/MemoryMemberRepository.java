/*
package moviepy.moviepy_demo.repository;

import moviepy.moviepy_demo.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return null;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByUserId(String userId) {
        return store.values().stream()
                .filter(member -> member.getUserId().equals(userId))
                .findAny();
    }

    @Override
    public Optional<Member> findByUserName(String userName) {
        return store.values().stream()
                .filter(member -> member.getUserName().equals(userName))
                .findAny();
    }

    @Override
    public Optional<Member> findByPassword(String password) {
        return store.values().stream()
                .filter(member -> member.getPassword().equals(password))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {store.clear();}
}
*/

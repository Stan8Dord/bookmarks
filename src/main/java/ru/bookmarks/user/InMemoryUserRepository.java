package ru.bookmarks.user;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class InMemoryUserRepository implements UserRepository {
    private static final Map<Integer, User> users = new HashMap<>();

    @Override
    public List<User> findAll() {
        return users.values().stream().collect(Collectors.toList());
    }

    @Override
    public User save(User user) {
        return users.put(user.getId(), user);
    }
}

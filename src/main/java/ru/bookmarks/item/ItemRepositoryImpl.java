package ru.bookmarks.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ItemRepositoryImpl implements ItemRepository {
    private static final List<Item> items = new ArrayList<>();
    private static long itemId = 0;

    @Override
    public Item save(Item item) {
        item.setId(itemId++);
        items.add(item);

        return item;
    }

    @Override
    public List<Item> findByUserId(int userId) {
        return items.stream().filter((item) -> item.getUserId() == userId).collect(Collectors.toList());
    }

    @Override
    public void deleteByUserIdAndItemId(int userId, long itemId) {
        items.removeIf(item -> item.getUserId() == userId && item.getId() == itemId);
    }
}

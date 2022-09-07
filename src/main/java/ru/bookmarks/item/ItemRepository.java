package ru.bookmarks.item;

import java.util.List;

interface ItemRepository {

    List<Item> findByUserId(int userId);

    Item save(Item item);

    void deleteByUserIdAndItemId(int userId, long itemId);
}

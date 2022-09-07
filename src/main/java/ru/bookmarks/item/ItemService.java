package ru.bookmarks.item;

import java.util.List;

public interface ItemService {
    List<Item> getItems(int userId);

    Item addNewItem(int userId, Item item);

    void deleteItem(int userId, long itemId);
}

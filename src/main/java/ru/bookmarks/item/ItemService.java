package ru.bookmarks.item;

import java.util.List;

public interface ItemService {
    List<ItemDto> getItems(int userId);

    Item addNewItem(int userId, ItemDto itemDto);

    void deleteItem(int userId, long itemId);
}

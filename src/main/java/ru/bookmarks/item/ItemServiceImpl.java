package ru.bookmarks.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final ItemRepository repository;
    @Override
    public List<Item> getItems(int userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public Item addNewItem(int userId, Item item) {
        return repository.save(item);
    }

    @Override
    public void deleteItem(int userId, long itemId) {
        repository.deleteByUserIdAndItemId(userId, itemId);
    }
}

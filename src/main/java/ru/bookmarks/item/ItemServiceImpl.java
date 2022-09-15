package ru.bookmarks.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final ItemRepository repository;
    @Override
    public List<ItemDto> getItems(int userId) {
        List<Item> items = repository.findByUserId(userId);

        return ItemDtoMapper.itemToItemDto(items);
    }

    @Override
    public Item addNewItem(int userId, ItemDto itemDto) {
        return repository.save(ItemDtoMapper.itemDtoToItem(itemDto, userId));
    }

    @Override
    public void deleteItem(int userId, long itemId) {
        repository.deleteByUserIdAndItemId(userId, itemId);
    }
}

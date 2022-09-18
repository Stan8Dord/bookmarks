package ru.bookmarks.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ItemServiceImpl implements ItemService {
    private final ItemRepository repository;
    @Override
    @Transactional
    public List<ItemDto> getItems(int userId) {
        List<Item> items = repository.findByUserId(userId);

        return ItemDtoMapper.itemToItemDto(items);
    }

    @Override
    @Transactional
    public Item addNewItem(int userId, ItemDto itemDto) {
        return repository.save(ItemDtoMapper.itemDtoToItem(itemDto, userId));
    }

    @Override
    @Transactional
    public void deleteItem(int userId, long itemId) {
        repository.deleteByUserIdAndItemId(userId, itemId);
    }
}

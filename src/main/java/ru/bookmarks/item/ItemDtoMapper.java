package ru.bookmarks.item;


import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@NoArgsConstructor
public class ItemDtoMapper {
    public static ItemDto itemToItemDto(Item item) {
        return new ItemDto(
                item.getId(),
                item.getUserId(),
                item.getUrl(),
                new HashSet<>(item.getTags()));
    }

    public static List<ItemDto> itemToItemDto(Iterable<Item> items) {
        List<ItemDto> dtos = new ArrayList<>();
        for (Item item : items) {
            dtos.add(itemToItemDto(item));
        }

        return dtos;
    }

    public static Item itemDtoToItem(ItemDto iDto, int userId) {
        Item item = new Item();
        item.setUserId(userId);
        item.setUrl(iDto.getUrl());
        item.setTags(iDto.getTags());

        return item;
    }
}

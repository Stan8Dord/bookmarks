package ru.bookmarks.item;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;

    @GetMapping
    public List<Item> get(@RequestHeader("X-Later-User-Id") int userId) {
        return itemService.getItems(userId);
    }

    @PostMapping
    public Item add(@RequestHeader("X-Later-User-Id") int userId,
                    @RequestBody Item item) {
        return itemService.addNewItem(userId, item);
    }

    @DeleteMapping("/{itemId}")
    public void deleteItem(@RequestHeader("X-Later-User-Id") int userId,
                           @PathVariable long itemId) {
        itemService.deleteItem(userId, itemId);
    }
}

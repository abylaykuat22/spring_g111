package kz.bitlab.springbootapp.db;

import java.util.ArrayList;
import java.util.List;
import kz.bitlab.springbootapp.models.Item;

public class DBManager {

  private static List<Item> items = new ArrayList<>();

  private static Long id = 4L;

  static {
    items.add(Item.builder() // применение @Builder
        .id(1L)
        .name("Iphone 13")
        .isExist(true)
        .build());
    items.add(new Item(2L, "IPhone 11", "16 GB RAM", 400000, false));
    items.add(new Item(3L, "IPhone 13", "32 GB RAM", 600000, true));
  }

  public static List<Item> getItems() {
    return items;
  }

  public static Item getItemById(Long id) {
    for (Item item : items) {
      if (item.getId() == id) {
        return item;
      }
    }
    return null;
  }

  public static void addItem(Item item) {
    item.setId(id);
    items.add(item);
    id++;
  }
}

package kz.bitlab.springbootapp.db;

import java.util.ArrayList;
import java.util.List;
import kz.bitlab.springbootapp.models.Item;

public class DBManager {

  private static List<Item> items = new ArrayList<>();

  private static Long id = 4L;

  static {
    items.add(new Item(1L, "IPhone X", "8 GB RAM", 300000));
    items.add(new Item(2L, "IPhone 11", "16 GB RAM", 400000));
    items.add(new Item(3L, "IPhone 13", "32 GB RAM", 500000));
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

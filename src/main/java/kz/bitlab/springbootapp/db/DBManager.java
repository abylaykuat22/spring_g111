package kz.bitlab.springbootapp.db;

import java.util.ArrayList;
import java.util.List;
import kz.bitlab.springbootapp.models.Item;

public class DBManager {
  private static List<Item> items = new ArrayList<>();

  static {
    items.add(new Item(1L, "IPhone X", "8 GB RAM", 300000));
    items.add(new Item(2L, "IPhone 11", "16 GB RAM", 400000));
    items.add(new Item(3L, "IPhone 13", "32 GB RAM", 500000));
  }

  public static List<Item> getItems() {
    return items;
  }
}

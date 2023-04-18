package kz.bitlab.springbootapp.services.impl;

import java.util.ArrayList;
import java.util.List;
import kz.bitlab.springbootapp.models.Item;
import kz.bitlab.springbootapp.services.ItemService;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

  private List<Item> items = new ArrayList<>();
  private Long id = 4L;

  {
    items.add(Item.builder() // применение @Builder
        .id(1L)
        .name("Iphone 13")
        .isExist(true)
        .build());
    items.add(new Item(2L, "IPhone 11", "16 GB RAM", 400000, false));
    items.add(new Item(3L, "IPhone 13", "32 GB RAM", 600000, true));
  }


  @Override
  public List<Item> getItems() {
    return items;
  }

  @Override
  public Item getItemById(Long id) {
    for (Item item : items) {
      if (item.getId() == id) {
        return item;
      }
    }
    return null;
  }

  @Override
  public void createItem(Item item) {
    item.setId(id);
    items.add(item);
    id++;
  }
}

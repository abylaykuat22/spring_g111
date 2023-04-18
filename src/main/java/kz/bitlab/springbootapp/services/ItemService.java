package kz.bitlab.springbootapp.services;

import java.util.List;
import kz.bitlab.springbootapp.models.Item;

public interface ItemService {

  List<Item> getItems();

  Item getItemById(Long id);

  void createItem(Item item);
}

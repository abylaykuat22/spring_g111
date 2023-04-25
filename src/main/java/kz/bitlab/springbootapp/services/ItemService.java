package kz.bitlab.springbootapp.services;

import java.util.List;
import kz.bitlab.springbootapp.models.Item;

public interface ItemService {

  List<Item> getItems();

  Item getItemById(Long id);

  Item getItemByName(String name);

  void createItem(Item item);

  void editItem(Item item);

  void deleteItemById(Long id);

  void deleteItemsByBrandId(Long brandId);
}

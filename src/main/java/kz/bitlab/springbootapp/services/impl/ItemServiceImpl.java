package kz.bitlab.springbootapp.services.impl;

import java.util.List;
import kz.bitlab.springbootapp.enums.ItemStatus;
import kz.bitlab.springbootapp.models.Item;
import kz.bitlab.springbootapp.repositories.ItemRepository;
import kz.bitlab.springbootapp.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

  @Autowired
  private ItemRepository itemRepository;

  @Override
  public List<Item> getItems() {
    return itemRepository.findAll();
  }

  @Override
  public Item getItemById(Long id) {
    return itemRepository.findById(id).orElse(null);
  }

  @Override
  public Item getItemByName(String name) {
    return itemRepository.getItemByName(name);
  }

  @Override
  public void createItem(Item item) {

    item.setStatus(ItemStatus.IN_STOCK);
    itemRepository.save(item);
  }

  @Override
  public void editItem(Item item) {
    itemRepository.save(item);
  }

  @Override
  public void deleteItemById(Long id) {
    itemRepository.deleteById(id);
  }

  @Override
  public void deleteItemsByBrandId(Long brandId) {
    itemRepository.deleteItemsByBrandId(brandId);
  }
}

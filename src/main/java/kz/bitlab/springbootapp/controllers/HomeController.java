package kz.bitlab.springbootapp.controllers;

import java.util.List;
import kz.bitlab.springbootapp.enums.ItemStatus;
import kz.bitlab.springbootapp.models.Brand;
import kz.bitlab.springbootapp.models.Item;
import kz.bitlab.springbootapp.services.BrandService;
import kz.bitlab.springbootapp.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

  @Autowired
  private ItemService itemService;

  @Autowired
  private BrandService brandService;

  @GetMapping("/")
  public String homePage(Model model) {
    List<Item> items = itemService.getItems();
    List<Brand> brands = brandService.findAll();
    model.addAttribute("items", items);
    model.addAttribute("brandter", brands);
    return "home";
  }

  @GetMapping("/details/{id}")
  public String itemDetails(@PathVariable Long id, Model model) {
    Item item = itemService.getItemById(id);
    List<Brand> brands = brandService.findAll();
    List<ItemStatus> statuses = List.of(ItemStatus.values());
    if (item != null) {
      model.addAttribute("zat", item);
      model.addAttribute("brands", brands);
      model.addAttribute("statuses", statuses);
      return "details";
    }
    return "home";
  }

  @PostMapping("/addItem")
  public String addItem(Item item) {
    itemService.createItem(item);
    return "redirect:/";
  }

  @PostMapping("/editItem")
  public String editItem(Item item) {
    itemService.editItem(item);
    return "redirect:/";
  }

  @PostMapping("/deleteItem")
  public String deleteItem(@RequestParam Long id) {
    itemService.deleteItemById(id);
    return "redirect:/";
  }
}

package kz.bitlab.springbootapp.controllers;

import java.util.List;
import kz.bitlab.springbootapp.models.Item;
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

  @GetMapping("/")
  public String homePage(Model model) {
    List<Item> items = itemService.getItems();
    model.addAttribute("items", items);
    return "home";
  }

  @GetMapping("/details/{id}")
  public String itemDetails(@PathVariable Long id, Model model) {
    Item item = itemService.getItemById(id);
    if (item != null) {
      model.addAttribute("zat", item);
      return "details";
    }
    return "home";
  }

  @GetMapping("/detailsbyname/{name}")
  public String itemDetailsByName(@PathVariable String name, Model model) {
    Item item = itemService.getItemByName(name);
    if (item != null) {
      model.addAttribute("zat", item);
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

package kz.bitlab.springbootapp.controllers;

import java.util.List;
import kz.bitlab.springbootapp.db.DBManager;
import kz.bitlab.springbootapp.models.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

  @GetMapping("/") // @WebServlet(value='/') + doGet()
  public String homePage(Model model) {
    List<Item> items = DBManager.getItems();
    model.addAttribute("items", items); //reg.setAttribute("items", items)
    return "home"; //req.getRequestDispatcher("/home.jsp").forward(req, resp);
  }

  @GetMapping("/details/{id}")
  public String itemDetails(@PathVariable Long id, Model model) { //req.getParameter("id")
    Item item = DBManager.getItemById(id);
    if (item != null) {
      model.addAttribute("zat", item);
      return "details";
    }
    return "home"; //req.getRequestDispatcher("/").forward(req, resp)
  }

  @PostMapping("/addItem")
  public String addItem(@RequestParam String name,
                        @RequestParam String description,
                        @RequestParam int price) {
    Item item = new Item();
    item.setName(name);
    item.setPrice(price);
    item.setDescription(description);
    DBManager.addItem(item);
    return "redirect:/"; //resp.sendRedirect("/")
  }
}

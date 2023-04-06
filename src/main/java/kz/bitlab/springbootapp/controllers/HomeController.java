package kz.bitlab.springbootapp.controllers;

import java.util.List;
import kz.bitlab.springbootapp.db.DBManager;
import kz.bitlab.springbootapp.models.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
  @GetMapping("/") // @WebServlet(value='/') + doGet()
  public String homePage(Model model) {
    List<Item> items = DBManager.getItems();
    model.addAttribute("items", items); //reg.setAttribute("items", items)
    return "home"; //req.getRequestDispatcher("/home.jsp").forward(req, resp);
  }

  @GetMapping("/second")
  public String secondStranica() {
    return "second";
  }
}

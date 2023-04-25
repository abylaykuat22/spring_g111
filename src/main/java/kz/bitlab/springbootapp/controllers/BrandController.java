package kz.bitlab.springbootapp.controllers;

import java.util.List;
import kz.bitlab.springbootapp.models.Brand;
import kz.bitlab.springbootapp.models.Country;
import kz.bitlab.springbootapp.services.BrandService;
import kz.bitlab.springbootapp.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BrandController {

  @Autowired
  private BrandService brandService;

  @Autowired
  private CountryService countryService;

  @GetMapping("/brands")
  public String brandsPage(Model model) {
    List<Brand> brands = brandService.findAll();
    List<Country> countries = countryService.findAll();
    model.addAttribute("brands", brands);
    model.addAttribute("countries", countries);
    return "brands";
  }

  @PostMapping("/addBrand")
  public String addBrand(Brand brand) {
    brandService.addBrand(brand);
    return "redirect:/brands";
  }

  @GetMapping("/detailsBrand/{id}")
  public String brandDetails(Model model, @PathVariable Long id) {
    Brand brand = brandService.findById(id);
    if (brand != null) {
      model.addAttribute("brand", brand);
      return "detailsBrand";
    }
    return "brands";
  }

  @PostMapping("/deleteBrand")
  public String deleteBrand(@RequestParam Long id) {
    System.out.println("controller " + id);
    brandService.deleteBrandById(id);
    return "redirect:/brands";
  }
}

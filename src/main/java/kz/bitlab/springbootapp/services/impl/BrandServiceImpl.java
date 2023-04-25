package kz.bitlab.springbootapp.services.impl;

import java.util.List;
import kz.bitlab.springbootapp.models.Brand;
import kz.bitlab.springbootapp.repositories.BrandRepository;
import kz.bitlab.springbootapp.services.BrandService;
import kz.bitlab.springbootapp.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandServiceImpl implements BrandService {

  @Autowired
  private BrandRepository brandRepository;

  @Autowired
  private ItemService itemService;

  @Override
  public List<Brand> findAll() {
    return brandRepository.findAll();
  }

  @Override
  public void addBrand(Brand brand) {
    brandRepository.save(brand);
  }

  @Override
  public Brand findById(Long id) {
    return brandRepository.findById(id).orElse(null);
  }

  @Override
  public void deleteBrandById(Long id) {
    System.out.println(id);
    itemService.deleteItemsByBrandId(id);
    brandRepository.deleteById(id);
  }
}

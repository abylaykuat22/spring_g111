package kz.bitlab.springbootapp.services;

import java.util.List;
import kz.bitlab.springbootapp.models.Brand;

public interface BrandService {

  List<Brand> findAll();

  void addBrand(Brand brand);

  Brand findById(Long id);

  void deleteBrandById(Long id);
}

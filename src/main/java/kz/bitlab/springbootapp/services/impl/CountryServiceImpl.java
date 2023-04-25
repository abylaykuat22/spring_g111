package kz.bitlab.springbootapp.services.impl;

import java.util.List;
import kz.bitlab.springbootapp.models.Country;
import kz.bitlab.springbootapp.repositories.CountryRepository;
import kz.bitlab.springbootapp.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements CountryService {

  @Autowired
  private CountryRepository countryRepository;

  @Override
  public List<Country> findAll() {
    return countryRepository.findAll();
  }
}

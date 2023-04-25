package kz.bitlab.springbootapp.services;

import java.util.List;
import kz.bitlab.springbootapp.models.Country;

public interface CountryService {

  List<Country> findAll();
}

package kz.bitlab.springbootapp.repositories;

import kz.bitlab.springbootapp.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

}

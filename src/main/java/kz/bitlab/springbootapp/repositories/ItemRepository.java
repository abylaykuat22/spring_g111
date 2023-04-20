package kz.bitlab.springbootapp.repositories;

import kz.bitlab.springbootapp.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

  Item getItemByName(String name);

}

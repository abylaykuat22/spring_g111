package kz.bitlab.springbootapp.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Item {

  private Long id;
  private String name;
  private String description;
  private double price;
  private boolean isExist;

}

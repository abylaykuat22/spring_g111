package kz.bitlab.springbootapp.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "items")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Item {

  @Id // primary key
  @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
  @Column(name = "id")
  private Long id;

  @Column(name = "i_name", length = 20)
  private String name;

  @Column(name = "i_description", columnDefinition = "text")
  private String description;

  @Column(name = "i_price")
  private double price;

  @Column(name = "is_exist")
  private boolean isExist;
}

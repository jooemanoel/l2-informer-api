package persistence.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQueries;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "item_name", schema = "interlude")
@NamedNativeQueries({
    @NamedNativeQuery(name = Item.LISTAR, query = "SELECT * FROM interlude.item_name", resultClass = Item.class)
})
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Item {

  public static final String LISTAR = "ITEM_LISTAR";

  @Id
  private Integer id;

  private String name;

  @Column(name = "add_name")
  private String addName;
}

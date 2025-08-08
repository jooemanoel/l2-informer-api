package persistence.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DroplistDTO {

  private Integer mobId;

  private Integer itemId;

  private Integer category;

  private Integer min;

  private Integer max;

  private Integer chance;

  private String mobName;

  private String itemName;
}

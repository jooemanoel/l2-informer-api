package persistence.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class NpcSkillDTO {

  
  private Integer id;

  private Integer level;

  private String name;

}

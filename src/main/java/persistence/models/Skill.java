package persistence.models;

import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.NamedNativeQueries;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.SqlResultSetMapping;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import persistence.dto.SkillDTO;

@Entity
@Table(name = "skills", schema = "interlude")
@IdClass(SkillId.class)
@SqlResultSetMapping(name = "SkillDTOMapping", classes = @ConstructorResult(targetClass = SkillDTO.class, columns = {
    @ColumnResult(name = "id", type = Integer.class),
    @ColumnResult(name = "name", type = String.class),
}))
@NamedNativeQueries({
    @NamedNativeQuery(name = Skill.LISTAR, query = "SELECT * FROM interlude.skills", resultClass = Skill.class),
    @NamedNativeQuery(name = Skill.LISTAR_POR_ID, query = "SELECT * FROM interlude.skills WHERE id = :id", resultClass = Skill.class),
    @NamedNativeQuery(name = Skill.LISTAR_ID_NAME, query = "SELECT DISTINCT id, name FROM interlude.skills", resultSetMapping = "SkillDTOMapping"),
    @NamedNativeQuery(name = Skill.LISTAR_ID_NAME_POR_ID, query = "SELECT DISTINCT id, name FROM interlude.skills WHERE id = :id", resultSetMapping = "SkillDTOMapping"),
})
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Skill {

  public static final String LISTAR = "SKILL_LISTAR";
  public static final String LISTAR_POR_ID = "SKILL_LISTAR_POR_ID";
  public static final String LISTAR_ID_NAME = "SKILL_LISTAR_ID_NAME";
  public static final String LISTAR_ID_NAME_POR_ID = "SKILL_LISTAR_ID_NAME_POR_ID";

  @Id
  private Integer id;

  @Id
  private Integer level;

  private String name;

}
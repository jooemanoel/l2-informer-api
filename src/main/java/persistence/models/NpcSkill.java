package persistence.models;

import java.io.Serializable;

import jakarta.persistence.Column;
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
import persistence.dto.NpcSkillDTO;

@Entity
@Table(name = "npcskills")
@IdClass(NpcSkill.NpcSkillId.class)
@SqlResultSetMapping(name = "SkillMapping", classes = @ConstructorResult(targetClass = NpcSkillDTO.class, columns = {
        @ColumnResult(name = "skillid", type = Integer.class),
        @ColumnResult(name = "level", type = Integer.class),
        @ColumnResult(name = "skillName", type = String.class),
}))
@NamedNativeQueries({
        @NamedNativeQuery(name = NpcSkill.LISTAR, query = "SELECT * FROM interlude.npcskills", resultClass = NpcSkill.class),
        @NamedNativeQuery(name = NpcSkill.LISTAR_POR_NPC, query = "SELECT * FROM interlude.npcskills WHERE npcid = :npcid", resultClass = NpcSkill.class),
        @NamedNativeQuery(name = NpcSkill.LISTAR_POR_NPC_COM_NOMES, query = "SELECT DISTINCT npcskills.skillid, npcskills.level, skills.name AS skillName FROM npcskills INNER JOIN skills ON npcskills.skillid = skills.id AND npcskills.level = skills.level WHERE npcskills.npcid = :npcid", resultSetMapping = "SkillMapping")
})
@NoArgsConstructor
@AllArgsConstructor
@Data
public class NpcSkill {

  public static final String LISTAR = "NPC_SKILL_LISTAR";
  public static final String LISTAR_POR_NPC = "NPC_SKILL_LISTAR_POR_NPC";
  public static final String LISTAR_POR_NPC_COM_NOMES = "LISTAR_POR_NPC_COM_NOMES";

  @Id
  @Column(name = "npcid", nullable = false)
  private Integer npcid;

  @Id
  @Column(name = "skillid", nullable = false)
  private Integer skillid;

  @Id
  @Column(name = "level", nullable = false)
  private Integer level;

  @NoArgsConstructor
  @AllArgsConstructor
  @Data
  public static class NpcSkillId implements Serializable {
    private Integer npcid;
    private Integer skillid;
    private Integer level;
  }
}

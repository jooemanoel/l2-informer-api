package persistence.models;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQueries;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.SqlResultSetMapping;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import persistence.dto.NpcDTO;

@Entity
@Table(name = "npc", schema = "interlude")
@SqlResultSetMapping(name = "NpcDTOMapping", classes = @ConstructorResult(targetClass = NpcDTO.class, columns = {
        @ColumnResult(name = "id", type = BigDecimal.class),
        @ColumnResult(name = "name", type = String.class),
}))
@NamedNativeQueries({
        @NamedNativeQuery(name = Npc.LISTAR_ID_NAME, query = "SELECT id, name FROM interlude.npc", resultSetMapping = "NpcDTOMapping"),
        @NamedNativeQuery(name = Npc.LISTAR, query = "SELECT * FROM interlude.npc", resultClass = Npc.class)
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Npc {

    public static final String LISTAR_ID_NAME = "NPC_LISTAR_ID_NAME";
    public static final String LISTAR = "NPC_LISTAR";

    @Id
    @Column(nullable = false, precision = 11, scale = 0)
    private BigDecimal id;

    @Column(nullable = false)
    private Integer idTemplate;

    private String name;

    private Integer serverSideName;

    private String title;

    private Integer serverSideTitle;

    @Column(name = "class")
    private String className;

    private BigDecimal collisionRadius;

    private BigDecimal collisionHeight;

    private BigDecimal level;

    private String sex;

    private String type;

    private Integer attackrange;

    private BigDecimal hp;

    private BigDecimal mp;

    private BigDecimal hpreg;

    private BigDecimal mpreg;

    private BigDecimal str;

    private BigDecimal con;

    private BigDecimal dex;

    @Column(name = "`int`")
    private BigDecimal intelligence;

    private BigDecimal wit;

    private BigDecimal men;

    private BigDecimal exp;

    private BigDecimal sp;

    private BigDecimal patk;

    private BigDecimal pdef;

    private BigDecimal matk;

    private BigDecimal mdef;

    private BigDecimal atkspd;

    private BigDecimal aggro;

    private BigDecimal matkspd;

    private BigDecimal rhand;

    private BigDecimal lhand;

    private BigDecimal armor;

    private BigDecimal walkspd;

    private BigDecimal runspd;

    private String factionId;

    private BigDecimal factionRange;

    private Integer isUndead;

    private BigDecimal absorbLevel;

    @Enumerated(EnumType.STRING)
    private AbsorbType absorbType;

    public enum AbsorbType {
        FULL_PARTY, LAST_HIT, PARTY_ONE_RANDOM
    }
}

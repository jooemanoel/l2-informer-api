package persistence.models;

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
import persistence.dto.DroplistDTO;

@Entity
@Table(name = "droplist", schema = "interlude")
@IdClass(DroplistId.class)
@SqlResultSetMapping(name = "DroplistDTOMapping", classes = @ConstructorResult(targetClass = DroplistDTO.class, columns = {
                @ColumnResult(name = "mobId", type = Integer.class),
                @ColumnResult(name = "itemId", type = Integer.class),
                @ColumnResult(name = "category", type = Integer.class),
                @ColumnResult(name = "min", type = Integer.class),
                @ColumnResult(name = "max", type = Integer.class),
                @ColumnResult(name = "chance", type = Integer.class),
                @ColumnResult(name = "mobName", type = String.class),
                @ColumnResult(name = "itemName", type = String.class)
}))
@NamedNativeQueries({
                @NamedNativeQuery(name = Droplist.LISTAR, query = "SELECT * FROM interlude.droplist", resultClass = Droplist.class),
                @NamedNativeQuery(name = Droplist.LISTAR_POR_NPC, query = "SELECT * FROM interlude.droplist WHERE mobId = :mobId", resultClass = Droplist.class),
                @NamedNativeQuery(name = Droplist.LISTAR_COM_NOMES, query = "SELECT droplist.mobId, npc.name AS mobName, droplist.itemId, item_name.name AS itemName, droplist.category, droplist.min, droplist.max, droplist.chance FROM droplist INNER JOIN npc ON droplist.mobId = npc.id INNER JOIN item_name ON droplist.itemId = item_name.id", resultSetMapping = "DroplistDTOMapping"),
                @NamedNativeQuery(name = Droplist.LISTAR_POR_NPC_COM_NOMES, query = "SELECT droplist.mobId, npc.name AS mobName, droplist.itemId, item_name.name AS itemName, droplist.category, droplist.min, droplist.max, droplist.chance FROM droplist INNER JOIN npc ON droplist.mobId = npc.id INNER JOIN item_name ON droplist.itemId = item_name.id WHERE mobId = :mobId", resultSetMapping = "DroplistDTOMapping"),
                @NamedNativeQuery(name = Droplist.LISTAR_POR_ITEM_COM_NOMES, query = "SELECT droplist.mobId, npc.name AS mobName, droplist.itemId, item_name.name AS itemName, droplist.category, droplist.min, droplist.max, droplist.chance FROM droplist INNER JOIN npc ON droplist.mobId = npc.id INNER JOIN item_name ON droplist.itemId = item_name.id WHERE itemId = :itemId", resultSetMapping = "DroplistDTOMapping")
})
public class Droplist {

        public static final String LISTAR = "DROPLIST_LISTAR";
        public static final String LISTAR_POR_NPC = "DROPLIST_LISTAR_POR_NPC";
        public static final String LISTAR_COM_NOMES = "DROPLIST_LISTAR_COM_NOMES";
        public static final String LISTAR_POR_NPC_COM_NOMES = "DROPLIST_LISTAR_POR_NPC_COM_NOMES";
        public static final String LISTAR_POR_ITEM_COM_NOMES = "LISTAR_POR_ITEM_COM_NOMES";

        @Id
        @Column(name = "mobId")
        public Integer mobId;

        @Id
        @Column(name = "itemId")
        public Integer itemId;

        @Id
        @Column(name = "category")
        public Integer category;

        @Column(name = "min", nullable = false)
        public Integer min;

        @Column(name = "max", nullable = false)
        public Integer max;

        @Column(name = "chance", nullable = false)
        public Integer chance;

}
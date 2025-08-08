package persistence.models;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DroplistId implements Serializable {
    private Integer mobId;
    private Integer itemId;
    private Integer category;
}
package cys.partner.api.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import java.util.UUID;

@Document(collation = "item")
@Data
@NoArgsConstructor
public class Item {

    @Id
    private UUID Id;
    private String Title;
    private String Desc;
}

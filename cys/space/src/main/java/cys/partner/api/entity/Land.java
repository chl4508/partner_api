package cys.partner.api.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.UUID;

@Document(collection = "asset")
@JsonInclude(JsonInclude.Include.NON_NULL) // => c# bsonIgnoreExtraElements
@Data
public class Land {

    @Id
    private UUID id;

    @Field(name = "profileid")
    private UUID profileId;
}

package cys.partner.api.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import cys.partner.api.entity.LangTxt;
import lombok.Data;

import java.util.UUID;

@Data
public class CreateItemRequest {

    @JsonIgnore
    private UUID id;

    @JsonIgnore
    private UUID profileId;

    @JsonIgnore
    private UUID worldId;

    @JsonIgnore
    private int assetType = 1;

    private CreateItemTxt txt;

    private CreateItemResource resource;

    private CreateItemOption option;

    @Data
    public class CreateItemTxt{
        private LangTxt title;

        private LangTxt desc;

        private String[] hashtag;

        public CreateItemTxt(){}
    }

    @Data
    public class CreateItemResource{
        private String preview;

        private String thumbnail;

        public CreateItemResource(){}
    }

    @Data
    public class CreateItemOption{
        private String templateId;

        private int templateVersion;

        private int version;

        private String Category;

        private CreateItemPrice price;

        public CreateItemOption(){

        }

        public CreateItemOption(CreateItemPrice price){
            this.price = price;
        }

    }

    @Data
    public static class CreateItemPrice{
        private int type;

        private int amount;

        public CreateItemPrice(){
        }
    }
}

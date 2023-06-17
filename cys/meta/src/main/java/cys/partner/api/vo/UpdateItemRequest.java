package cys.partner.api.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import cys.partner.api.entity.LangTxt;
import lombok.Data;

import java.util.UUID;

@Data
public class UpdateItemRequest {
    @JsonIgnore
    private UUID id;

    private UpdateItemTxt txt;

    private UpdateItemOption option;

    @Data
    public class UpdateItemTxt{
        private LangTxt title;

        private LangTxt desc;

        private String[] hashtag;

        public UpdateItemTxt(){}
    }

    @Data
    public class UpdateItemOption{

        private int version;

        private UpdateItemPrice price;

        public UpdateItemOption(){}
    }

    @Data
    public class UpdateItemPrice{
        private int type;

        private int amount;

        public UpdateItemPrice(){}
    }
}

package cys.partner.api.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import cys.partner.api.entity.LangTxt;
import lombok.Data;

import java.util.UUID;

@Data
public class UpdateItemRequest {
    @JsonIgnore
    private UUID id;

    private ItemTxt txt;

    private Option option;

    @Data
    public class ItemTxt{
        private LangTxt title;

        private LangTxt desc;

        private String[] hashtag;
    }

    @Data
    public class Option{

        private int version;

        private Price price;
    }

    @Data
    public class Price{
        private int type;

        private int amount;
    }
}

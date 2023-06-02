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

    private ItemTxt txt;

    private Resource resource;

    private Option option;

    @Data
    public class ItemTxt{
        private LangTxt title;

        private LangTxt desc;

        private String[] hashtag;
    }

    @Data
    public class Resource{
        private String preview;

        private String thumbnail;
    }

    @Data
    public class Option{
        private String templateId;

        private int templateVersion;

        private int version;

        private String Category;

        private Price price;
    }

    @Data
    public class Price{
        private int type;

        private int amount;
    }
}

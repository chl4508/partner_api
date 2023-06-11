package cys.partner.api.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.UUID;

@Document(collection = "item")
@JsonInclude(JsonInclude.Include.NON_NULL) // => c# bsonIgnoreExtraElements
@Data
public class Item {
    @Id
    private UUID id;

    @Field(name = "profileid")
    private UUID profileId;

    @Field(name = "worldid")
    private UUID worldId;

    @Field(name = "asset_type")
    private int assetType;

    private ItemTxt txt;

    private Resource Resource;

    private Option option;


    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL) // => c# bsonIgnoreExtraElements
    public static class ItemTxt {
        private LangTxt title;

        private LangTxt desc;

        private String[] hashtag;

        public ItemTxt(){

        }
        public ItemTxt(String title, String desc){
            this.title = new LangTxt(title);
            this.desc = new LangTxt(desc);
        }


    }

    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL) // => c# bsonIgnoreExtraElements
    public static class Resource{
        private String manifest;

        private String preview;

        private String thumbnail;
    }

    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL) // => c# bsonIgnoreExtraElements
    public static class Option{
        @Field(name="edit_date")
        private LocalDateTime editDate;

        private boolean template;

        @Field(name="templateid")
        private String templateId;

        @Field(name="template_version")
        private int templateVersion;

        @Field(name="sale_accept")
        private LocalDateTime saleAccept;

        @Field(name="sale_start")
        private LocalDateTime saleStart;

        @Field(name="sale_end")
        private LocalDateTime saleEnd;

        @Field(name="instant_sale")
        private boolean instantSale;

        private int version;

        @Field(name="sale_version")
        private int saleVersion;

        @Field(name="sale_status")
        private int saleStatus;

        @Field(name="ready_status")
        private int readyStatus;

        @Field(name="sale_review_status")
        private int saleReviewStatus;

        @Field(name="judge_status")
        private int judgeStatus;

        private boolean blind;

        private boolean delete;

        @Field(name="none_sale")
        private boolean noneSale;

        private String[] category;

        private Price price;

    }

    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL) // => c# bsonIgnoreExtraElements
    public static class Price{
        private int type;

        private int amount;
    }
}


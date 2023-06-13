package cys.partner.api.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import cys.partner.api.entity.LangTxt;
import lombok.Data;

import java.util.UUID;

@Data
public class UpdateAssetRequest {
    @JsonIgnore
    private UUID id;

    private UpdateAssetTxt txt;

    private UpdateAssetOption option;

    @Data
    public class UpdateAssetTxt{
        private LangTxt title;

        private LangTxt desc;

        private String[] hashtag;
    }

    @Data
    public class UpdateAssetOption{
        private int version;

        private UpdateAssetPrice price;

        @Data
        public class UpdateAssetPrice{
            private int type;

            private int amount;
        }
    }

}

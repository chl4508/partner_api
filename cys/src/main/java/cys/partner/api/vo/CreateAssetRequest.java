package cys.partner.api.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import cys.partner.api.entity.LangTxt;
import lombok.Data;

import java.util.UUID;

@Data
public class CreateAssetRequest {

    @JsonIgnore
    private UUID id;

    @JsonIgnore
    private UUID profileId;

    @JsonIgnore
    private UUID worldId;

    @JsonIgnore
    private int assetType = 1;

    private CreateAssetTxt txt;

    private CreateAssetResource resource;

    private CreateAssetOption option;

    @Data
    public class CreateAssetTxt{
        private LangTxt title;

        private LangTxt desc;

        private String[] hashtag;
    }

    @Data
    public class CreateAssetResource{
        private String preview;

        private String thumbnail;
    }

    @Data
    public class CreateAssetOption{
        private int version;

        private String Category;

        private CreateAssetPrice price;

        @Data
        public class CreateAssetPrice{
            private int type;

            private int amount;
        }
    }


}

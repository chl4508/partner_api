package cys.partner.api.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class GetItemListRequest {

    @JsonIgnore
    private String profileId;

    private int page = 1;

    private int limit = 50;

    private boolean noneSale;

    private String category;

    private boolean meCheck;

}

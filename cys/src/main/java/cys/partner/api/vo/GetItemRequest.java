package cys.partner.api.vo;

import lombok.Data;

@Data
public class GetItemRequest {

    private String itemId;

    private boolean meCheck;
}

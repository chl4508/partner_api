package cys.partner.api.application.service.impl;

import cys.partner.api.application.service.ItemService;
import cys.partner.api.vo.GetItemRequest;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

    /**
     *
     * @param request
     * @return
     */
    @Override
    public String GetItem(GetItemRequest request) {
        return "service Impl Test";
    }
}

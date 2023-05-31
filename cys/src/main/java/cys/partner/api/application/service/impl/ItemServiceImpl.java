package cys.partner.api.application.service.impl;

import cys.partner.api.application.repository.ItemRepository;
import cys.partner.api.application.service.ItemService;
import cys.partner.api.vo.GetItemRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    /**
     * 아이템 조회
     * @param request
     * @return
     */
    @Override
    public String GetItem(GetItemRequest request) {
        var item = itemRepository.findById(request.getItemId());
        return "service Impl Test";
    }
}

package cys.partner.api.application.service.impl;

import cys.partner.api.application.repository.ItemRepository;
import cys.partner.api.application.service.ItemService;
import cys.partner.api.entity.Item;
import cys.partner.api.vo.GetItemListRequest;
import cys.partner.api.vo.GetItemRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.UUID;

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
    public Item GetItem(GetItemRequest request) throws Exception {
        UUID uuid = UUID.fromString(request.getItemId());
        Item result = itemRepository.findById(uuid).get();
        if(!request.isMeCheck() && result.getOption().getSaleStatus() != 3){
             throw new FileNotFoundException("Not Found Item");
        }
        return result;
    }

    @Override
    public List<Item> GetItemList(GetItemListRequest request) throws Exception {
        return itemRepository.findItemList(request);
    }
}

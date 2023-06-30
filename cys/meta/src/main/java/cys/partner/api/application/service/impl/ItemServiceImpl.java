package cys.partner.api.application.service.impl;

import cys.partner.api.application.repository.ItemRepository;
import cys.partner.api.application.service.ItemService;
import cys.partner.api.config.errorcodes.ErrorCode;
import cys.partner.api.config.exception.CustomException;
import cys.partner.api.entity.Item;
import cys.partner.api.vo.CreateItemRequest;
import cys.partner.api.vo.GetItemListRequest;
import cys.partner.api.vo.GetItemRequest;
import cys.partner.api.vo.UpdateItemRequest;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ItemServiceImpl implements ItemService {
    private final Logger logger = LoggerFactory.getLogger(ItemServiceImpl.class);

    private final ItemRepository itemRepository;

    /**
     * 아이템 조회
     * @param request
     * @return
     */
    @Override
    @Cacheable(value = "Item", key = "#request", cacheManager = "testCacheManager")
    @KafkaListener(topics = "#{Item.id}", groupId = "item")
    public Item GetItem(GetItemRequest request) throws Exception {
        UUID uuid = UUID.fromString(request.getItemId());
        Item result = itemRepository.findById(uuid).orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND, "Not Found Item"));
        if(!request.isMeCheck() && result.getOption().getSaleStatus() != 3){
            throw new CustomException(ErrorCode.NOT_FOUND, "Not Found Item");
        }
        return result;
    }

    /**
     *
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public List<Item> GetItemList(GetItemListRequest request) throws Exception {
        return itemRepository.findItemList(request);
    }

    /**
     *
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    @CachePut(value = "Item", key = "#request", cacheManager = "testCacheManager")
    public Item CreateItem(CreateItemRequest request) throws Exception {
        Item item = new Item();
        item.setId(request.getId());
        item.setProfileId(UUID.randomUUID());
        item.setWorldId(UUID.randomUUID());
        item.setTxt(new Item.ItemTxt(request.getTxt().getTitle().ko, request.getTxt().getDesc().ko));
        String[] cateArray = request.getOption().getCategory().split(",");
        item.setOption(new Item.Option(cateArray));
        return itemRepository.insert(item);
    }

    /**
     *
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    @CachePut(value = "Item", key = "#request", cacheManager = "testCacheManager")
    public Item UpdateItem(UpdateItemRequest request) throws Exception {
        Item item = new Item();
        item.setId(request.getId());
        item.setTxt(new Item.ItemTxt(request.getTxt().getTitle().ko, request.getTxt().getDesc().ko));
        item.getOption().setPrice(new Item.Price(request.getOption().getPrice().getType(), request.getOption().getPrice().getAmount()));
        return itemRepository.save(item);
    }

}

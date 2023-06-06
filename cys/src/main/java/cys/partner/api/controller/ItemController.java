package cys.partner.api.controller;

import cys.partner.api.application.service.ItemService;
import cys.partner.api.entity.Item;
import cys.partner.api.vo.CreateItemRequest;
import cys.partner.api.vo.GetItemListRequest;
import cys.partner.api.vo.GetItemRequest;
import cys.partner.api.vo.UpdateItemRequest;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private ItemService service;

    /**
     * 아이템 조회 ( c#에서는 uuid 결과는 base62로 encoding 해서 보여주고있음)
     * @param itemId
     * @param request
     * @return
     * @throws Exception
     */
    @GetMapping(value = "-/{itemid}", produces = APPLICATION_JSON_VALUE)
    @Operation(summary = "아이템 조회", description = "아이템 정보가 조회됩니다.", tags = { "Item Controller" })
    public Item GetItem(@PathVariable("itemid") String itemId, @ModelAttribute GetItemRequest request)throws Exception {
        request.setItemId(itemId);
        return service.GetItem(request);
    }

    /**
     * 나의 아이템 조회 ( c#에서는 uuid 결과는 base62로 encoding 해서 보여주고있음)
     * @param itemId
     * @return
     * @throws Exception
     */
    @GetMapping(value = "me/{itemid}", produces = APPLICATION_JSON_VALUE)
    @Operation(summary = "나의 아이템 조회", description = "나의 아이템 정보가 조회됩니다.", tags = { "Item Controller" })
    public Item GetItem(@PathVariable("itemid") String itemId)throws Exception {
        GetItemRequest request = new GetItemRequest();
        request.setMeCheck(true);
        return GetItem(itemId, request);
    }

    /**
     * 아이템 리스트
     * @param profileId
     * @param request
     * @return
     * @throws Exception
     */
    @GetMapping(value = "{profileid}")
    @Operation(summary = "아이템 리스트", description = "아이템 리스트가 조회됩니다.", tags = { "Item Controller" })
    public List<Item> GetItemList(@PathVariable("profileid") String profileId, @ModelAttribute GetItemListRequest request)throws Exception{
        request.setProfileId(profileId);
        return service.GetItemList(request);
    }

    /**
     * 나의 아이템 리스트
     * @param request
     * @return
     * @throws Exception
     */
    @GetMapping(value = "me")
    @Operation(summary = "나의 아이템 리스트", description = "나의 아이템 리스트가 조회됩니다.", tags = { "Item Controller" })
    public List<Item> GetItemList(@ModelAttribute GetItemListRequest request)throws Exception{
        request.setMeCheck(true);
        return GetItemList("a9da7509-3649-4727-8353-c529cf94d96f", request);
    }

    /**
     * 아이템 생성
     * @param itemId
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping(value = "-/{itemid}")
    @Operation(summary = "아이템 생성", description = "아이템을 생성합니다.", tags = { "Item Controller" })
    public Item CreateItem(@PathVariable("itemid") String itemId, @RequestBody CreateItemRequest request)throws Exception{
        request.setId(UUID.fromString(itemId));
        return service.CreateItem(request);
    }

    /**
     * 아이템 수정
     * @param itemId
     * @param request
     * @return
     * @throws Exception
     */
    @PutMapping(value = "-/{itemid}")
    @Operation(summary = "아이템 수정", description = "아이템을 수정합니다.", tags = { "Item Controller" })
    public Item UpdateItem(@PathVariable("itemid") String itemId, @RequestBody UpdateItemRequest request)throws Exception{
        request.setId(UUID.fromString(itemId));
        return service.UpdateItem(request);
    }
}

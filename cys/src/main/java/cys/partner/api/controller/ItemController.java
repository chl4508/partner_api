package cys.partner.api.controller;

import cys.partner.api.application.service.ItemService;
import cys.partner.api.vo.GetItemRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private ItemService service;

    /**
     * 아이템 조회
     * @param itemId
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "-/{itemId}", method = RequestMethod.GET)
    public String GetItem(@PathVariable("itemId") String itemId, @ModelAttribute GetItemRequest request)throws Exception {
        request.setItemId(itemId);
        var test = service.GetItem(request);
        return "Controller 테스트 "+request.getItemId() + " | test : "+test;
    }

    /**
     * 나의 아이템 조회
     * @param itemId
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "me/{itemId}", method = RequestMethod.GET)
    public String GetItem(@PathVariable("itemId") String itemId)throws Exception {
        GetItemRequest request = new GetItemRequest();
        request.setMeCheck(true);
        return GetItem(itemId, request);
    }
}

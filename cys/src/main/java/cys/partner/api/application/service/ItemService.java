package cys.partner.api.application.service;

import cys.partner.api.entity.Item;
import cys.partner.api.vo.GetItemListRequest;
import cys.partner.api.vo.GetItemRequest;

import java.util.List;

public interface ItemService {

    Item GetItem(GetItemRequest request) throws Exception;

    List<Item> GetItemList(GetItemListRequest request) throws Exception;
}

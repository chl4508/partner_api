package cys.partner.api.application.service;

import cys.partner.api.entity.Item;
import cys.partner.api.vo.CreateItemRequest;
import cys.partner.api.vo.GetItemListRequest;
import cys.partner.api.vo.GetItemRequest;
import cys.partner.api.vo.UpdateItemRequest;

import java.util.List;

public interface ItemService {

    Item GetItem(GetItemRequest request) throws Exception;

    List<Item> GetItemList(GetItemListRequest request) throws Exception;

    Item CreateItem(CreateItemRequest request) throws Exception;

    Item UpdateItem(UpdateItemRequest request) throws Exception;
}

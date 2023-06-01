package cys.partner.api.application.repository;

import cys.partner.api.entity.Item;
import cys.partner.api.vo.GetItemListRequest;

import java.util.List;

public interface CustomItemRepository {

    List<Item> findItemList(GetItemListRequest request);
}

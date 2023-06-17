package cys.partner.api.application.repository.impl;

import cys.partner.api.application.repository.CustomItemRepository;
import cys.partner.api.entity.Item;
import cys.partner.api.vo.GetItemListRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;
import java.util.UUID;

public class CustomItemRepositoryImpl implements CustomItemRepository {
    private final MongoOperations mongoOperations;

    @Autowired
    public CustomItemRepositoryImpl(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    @Override
    public List<Item> findItemList(GetItemListRequest request) {
        Query query = new Query();
        UUID profileUuid = UUID.fromString(request.getProfileId());
        query.addCriteria(Criteria.where("profileid").is(profileUuid));
        query.addCriteria(Criteria.where("option.none_sale").is(request.isNoneSale()));
        if(!request.isMeCheck()){
            query.addCriteria(Criteria.where("option.sale_status").is(3));
        }
        if(request.getCategory() != null){
            query.addCriteria(Criteria.where("option.category").in(request.getCategory()));
        }
        query.skip(request.getPage() -1);
        query.limit(request.getLimit());

        return mongoOperations.find(query, Item.class);
    }
}

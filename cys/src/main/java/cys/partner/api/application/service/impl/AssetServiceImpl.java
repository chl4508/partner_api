package cys.partner.api.application.service.impl;

import cys.partner.api.application.service.AssetService;
import cys.partner.api.entity.Asset;
import cys.partner.api.vo.GetAssetListRequest;
import cys.partner.api.vo.GetAssetRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AssetServiceImpl implements AssetService {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public Asset GetAsset(GetAssetRequest request) throws Exception {
        UUID uuid = UUID.fromString(request.getAssetId());
        Query query = new Query();
        Criteria criteria = Criteria.where("_id").is(uuid);
        query.addCriteria(criteria);
        return mongoTemplate.findOne(query, Asset.class);
    }

    @Override
    public List<Asset> GetAssetList(GetAssetListRequest request) throws Exception {
        UUID uuid = UUID.fromString(request.getProfileId());
        Query query = new Query();
        Criteria criteria = Criteria.where("_id").is(uuid);
        query.addCriteria(criteria);
        return mongoTemplate.find(query, Asset.class);
    }
}

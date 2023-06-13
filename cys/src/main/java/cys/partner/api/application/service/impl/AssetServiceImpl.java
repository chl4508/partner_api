package cys.partner.api.application.service.impl;

import com.mongodb.client.result.UpdateResult;
import cys.partner.api.application.service.AssetService;
import cys.partner.api.entity.Asset;
import cys.partner.api.entity.Item;
import cys.partner.api.vo.CreateAssetRequest;
import cys.partner.api.vo.GetAssetListRequest;
import cys.partner.api.vo.GetAssetRequest;
import cys.partner.api.vo.UpdateAssetRequest;
import lombok.RequiredArgsConstructor;
import org.bson.BsonDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
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

    @Override
    public Asset CreateAsset(CreateAssetRequest request) throws Exception {
        Asset asset = new Asset();
        asset.setId(request.getId());
        asset.setProfileId(UUID.randomUUID());
        asset.setWorldId(UUID.randomUUID());
        asset.setTxt(new Asset.AssetTxt(request.getTxt().getTitle().ko, request.getTxt().getDesc().ko));
        String[] cateArray = request.getOption().getCategory().split(",");
        asset.setOption(new Asset.Option(cateArray));
        return mongoTemplate.insert(asset);
    }

    @Override
    public Asset UpdateAsset(UpdateAssetRequest request) throws Exception {
        Query query = new Query();
        Criteria criteria = Criteria.where("_id").is(request.getId());
        query.addCriteria(criteria);

        Update update = new Update();
        update.set("txt.title.ko", request.getTxt().getTitle().ko);
        update.set("txt.desc.ko", request.getTxt().getDesc().ko);
        update.set("txt.hashtag", request.getTxt().getHashtag());
        update.set("option.version", request.getOption().getVersion());
        update.set("option.price", request.getOption().getPrice());

        mongoTemplate.updateFirst(query, update, "asset");
        return mongoTemplate.findOne(query, Asset.class);
    }
}

package cys.partner.api.application.repository;

import cys.partner.api.entity.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;

public interface ItemRepository extends MongoRepository<Item, UUID>, CustomItemRepository{

    List<Item> findByprofileId(UUID profileId);


}

package cys.partner.api.application.service;

import cys.partner.api.entity.Asset;
import cys.partner.api.vo.GetAssetListRequest;
import cys.partner.api.vo.GetAssetRequest;

import java.util.List;

public interface AssetService {

    Asset GetAsset(GetAssetRequest request) throws Exception;

    List<Asset> GetAssetList(GetAssetListRequest request) throws Exception;
}

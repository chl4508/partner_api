package cys.partner.api.application.service;

import cys.partner.api.entity.Asset;
import cys.partner.api.vo.CreateAssetRequest;
import cys.partner.api.vo.GetAssetListRequest;
import cys.partner.api.vo.GetAssetRequest;
import cys.partner.api.vo.UpdateAssetRequest;

import java.util.List;

public interface AssetService {

    Asset GetAsset(GetAssetRequest request) throws Exception;

    List<Asset> GetAssetList(GetAssetListRequest request) throws Exception;

    Asset CreateAsset(CreateAssetRequest request) throws Exception;

    Asset UpdateAsset(UpdateAssetRequest request) throws Exception;
}

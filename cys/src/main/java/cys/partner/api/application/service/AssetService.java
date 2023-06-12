package cys.partner.api.application.service;

import cys.partner.api.entity.Asset;
import cys.partner.api.vo.GetAssetRequest;

public interface AssetService {

    Asset GetAsset(GetAssetRequest request) throws Exception;
}

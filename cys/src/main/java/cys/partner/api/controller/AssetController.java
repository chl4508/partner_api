package cys.partner.api.controller;

import cys.partner.api.application.service.AssetService;
import cys.partner.api.entity.Asset;
import cys.partner.api.vo.GetAssetRequest;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/asset")
public class AssetController {

    @Autowired
    private AssetService assetService;

    @GetMapping(value = "-/{assetid}", produces = APPLICATION_JSON_VALUE)
    @Operation(summary = "애셋 조회", description = "애셋 정보가 조회됩니다.", tags = {"Asset Controller"})
    public Asset GetAsset(@PathVariable("assetid") String assetId, @RequestParam(value = "mecheck", required = false) boolean meCheck) throws Exception{
        GetAssetRequest request = new GetAssetRequest();
        request.setAssetId(assetId);
        request.setMeCheck(meCheck);
        return assetService.GetAsset(request);
    }
}

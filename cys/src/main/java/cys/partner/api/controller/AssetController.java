package cys.partner.api.controller;

import cys.partner.api.application.service.AssetService;
import cys.partner.api.entity.Asset;
import cys.partner.api.vo.*;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/asset")
public class AssetController {

    private final Logger logger = LoggerFactory.getLogger(AssetController.class);

    @Autowired
    private AssetService assetService;

    /**
     * 애셋 조회
     * @param assetId
     * @param meCheck
     * @return
     * @throws Exception
     */
    @GetMapping(value = "-/{assetid}", produces = APPLICATION_JSON_VALUE)
    @Operation(summary = "애셋 조회", description = "애셋 정보가 조회됩니다.", tags = {"Asset Controller"})
    public Asset GetAsset(@PathVariable("assetid") String assetId, @RequestParam(value = "mecheck", required = false) boolean meCheck) throws Exception{
        GetAssetRequest request = new GetAssetRequest();
        request.setAssetId(assetId);
        request.setMeCheck(meCheck);
        return assetService.GetAsset(request);
    }

    /**
     * 나의 애셋 조회
     * @param assetId
     * @return
     * @throws Exception
     */
    @GetMapping(value = "me/{assetid}", produces = APPLICATION_JSON_VALUE)
    @Operation(summary = "나의 애셋 조회", description = "나의 애셋 정보가 조회됩니다.", tags = {"Asset Controller"})
    public Asset GetAsset(@PathVariable("assetid") String assetId) throws Exception{
        return GetAsset(assetId, true);
    }

    /**
     * 애셋 리스트
     * @param profileId
     * @param request
     * @return
     * @throws Exception
     */
    @GetMapping(value = "{profileid}", produces = APPLICATION_JSON_VALUE)
    @Operation(summary = "애셋 리스트", description = "애셋 리스트가 조회됩니다.", tags = {"Asset Controller"})
    public List<Asset> GetAssetList(@PathVariable("profileid") String profileId, @ModelAttribute GetAssetListRequest request)throws Exception{
        request.setProfileId(profileId);
        return assetService.GetAssetList(request);
    }

    /**
     * 나의 애셋 리스트
     * @param request
     * @return
     * @throws Exception
     */
    @GetMapping(value = "me", produces = APPLICATION_JSON_VALUE)
    @Operation(summary = "나의 애셋 리스트", description = "나의 애셋 리스트가 조회됩니다.", tags = {"Asset Controller"})
    public List<Asset> GetAssetList(@ModelAttribute GetAssetListRequest request)throws Exception{
        request.setMeCheck(true);
        return GetAssetList("a9da7509-3649-4727-8353-c529cf94d96f", request);
    }

    /**
     * 애셋 생성
     * @param assetId
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping(value = "-/{assetid}")
    @Operation(summary = "애셋 생성", description = "애셋을 생성합니다.", tags = {"Asset Controller"})
    public Asset CreateAsset(@PathVariable("assetid") String assetId, @RequestBody CreateAssetRequest request)throws Exception{
        request.setId(UUID.fromString(assetId));
        return assetService.CreateAsset(request);
    }

    /**
     * 애셋 수정
     * @param assetId
     * @param request
     * @return
     * @throws Exception
     */
    @PutMapping(value = "-/{assetid}")
    @Operation(summary = "애셋 수정", description = "애셋을 수정합니다.", tags = {"Asset Controller"})
    public Asset UpdateAsset(@PathVariable("assetid") String assetId, @RequestBody UpdateAssetRequest request)throws Exception{
        request.setId(UUID.fromString(assetId));
        return assetService.UpdateAsset(request);
    }
}

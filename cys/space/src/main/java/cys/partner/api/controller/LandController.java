package cys.partner.api.controller;

import cys.partner.api.entity.Land;
import cys.partner.api.application.service.LandService;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/land")
public class LandController {

    private final Logger logger = LoggerFactory.getLogger(LandController.class);

    @Autowired
    private LandService landService;

    @GetMapping("{landid}")
    @Operation(summary = "랜드 조회", description = "랜드 정보가 조회됩니다.", tags = { "Land Controller" })
    public Land GetLand(@PathVariable("landid") String landId ) throws Exception{
        UUID landUuid = UUID.fromString(landId);
        return landService.GetLand(landUuid);
    }
}

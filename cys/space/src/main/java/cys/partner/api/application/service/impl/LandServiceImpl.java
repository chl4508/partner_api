package cys.partner.api.application.service.impl;

import cys.partner.api.application.service.LandService;
import cys.partner.api.entity.Land;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LandServiceImpl implements LandService {
    @Override
    public Land GetLand(UUID landId) throws Exception {
        //
        String clusterId = "meta";
        String clientId = "item";
        String serverUrl = "nats://127.0.0.1:4222";




        return new Land();
    }
}

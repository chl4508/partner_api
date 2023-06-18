package cys.partner.api.application.service;

import cys.partner.api.entity.Land;

import java.util.UUID;

public interface LandService {

    Land GetLand(UUID landId) throws Exception;
}

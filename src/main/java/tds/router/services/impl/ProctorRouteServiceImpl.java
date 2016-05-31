package tds.router.services.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.saml.SAMLCredential;
import org.springframework.stereotype.Service;
import tds.router.domain.TenancyChain;
import tds.router.generated.Route;
import tds.router.generated.Zone;
import tds.router.services.ProctorRouteService;
import tds.router.services.RouterConfigService;
import tds.router.util.TenancyChainHelper;

import java.util.List;

@Service
public class ProctorRouteServiceImpl implements ProctorRouteService {

    private static final String SBAC_TENANCY_ATTRIBUTE_NAME = "sbacTenancyChain";
    private static final Logger logger = LoggerFactory.getLogger(ProctorRouteServiceImpl.class);

    @Autowired
    RouterConfigService routerConfigService;

    public String routeProctor(SAMLCredential credential) {

        // Get a list of proctor role chains
        String[] tenancyList = credential.getAttributeAsStringArray(SBAC_TENANCY_ATTRIBUTE_NAME);

        List<TenancyChain> tenancyChains = TenancyChainHelper.createTenancyChains(tenancyList);
        List<TenancyChain> proctorChains = TenancyChainHelper.filterProctors(tenancyChains, routerConfigService.getTdsRouteConfig().getProctor());

        Route route = TenancyChainHelper.routeProctorByZone(proctorChains, routerConfigService.getTdsRouteConfig().getRoute());
        Zone zone = TenancyChainHelper.getZoneFromRoute(route, routerConfigService.getTdsRouteConfig().getZone());

        if (zone != null) {
            logger.info("Routing proctor to zone: {} with URL: {} ", zone.getKey(), zone.getProctorUrl());
            return zone.getProctorUrl();
        } else {
            logger.warn("Using default route for proctor to zone: {} with URL: {} ",
                    routerConfigService.getTdsRouteConfig().getZone().get(0).getKey(),
                    routerConfigService.getTdsRouteConfig().getZone().get(0).getProctorUrl());
            return routerConfigService.getTdsRouteConfig().getZone().get(0).getProctorUrl();
        }

    }

}

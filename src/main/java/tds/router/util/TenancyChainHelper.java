/*******************************************************************************
 * Educational Online Test Delivery System
 * Copyright (c) 2016 Regents of the University of California
 * <p>
 * Distributed under the AIR Open Source License, Version 1.0
 * See accompanying file AIR-License-1_0.txt or at
 * http://www.smarterapp.org/documents/American_Institutes_for_Research_Open_Source_Software_License.pdf
 * <p>
 * SmarterApp Open Source Assessment Software Project: http://smarterapp.org
 * Developed by Fairway Technologies, Inc. (http://fairwaytech.com)
 * for the Smarter Balanced Assessment Consortium (http://smarterbalanced.org)
 ******************************************************************************/

package tds.router.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tds.router.controllers.ProctorController;
import tds.router.domain.TenancyChain;
import tds.router.generated.Proctor;
import tds.router.generated.Route;
import tds.router.generated.Zone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TenancyChainHelper {

    private static final Logger logger = LoggerFactory.getLogger(ProctorController.class);

    public static Zone getZoneFromRoute(Route route, List<Zone> zones) {

        if (route != null) {
            for (Zone zone : zones) {
                if (zone.getKey().equalsIgnoreCase(route.getZone())) {
                    return zone;
                }
            }
        }
        return null;
    }

    /**
     * Route is checked in order of the JSON array of routes.
     *
     * @param proctorChains Tenancy Chains that meet the proctor definition for this user
     * @param routes        The route rules in order
     * @return The first Zone found for this user.
     */
    public static Route routeProctorByZone(List<TenancyChain> proctorChains, List<Route> routes) {

        for (Route route : routes) {
            for (TenancyChain chain : proctorChains) {
                if (route.getField().equalsIgnoreCase("InstitutionID") && route.getId().equalsIgnoreCase(chain.getInstitutionID())) {
                    return route;
                } else if (route.getField().equalsIgnoreCase("DistrictID") && route.getId().equalsIgnoreCase(chain.getDistrictID())) {
                    return route;
                }
            }
        }
        return null;
    }

    public static List<TenancyChain> createTenancyChains(String[] names) {
        return Arrays.asList(names).stream()
                .map(TenancyChain::new)
                .collect(Collectors.toList());
    }

    public static List<TenancyChain> filterProctors(List<TenancyChain> chains, List<Proctor> proctors) {

        List<TenancyChain> proctorChains = new ArrayList<>();

        for (Proctor proctor : proctors) {

            for (TenancyChain tenancyChain : chains) {
                if (proctor.getRole().equalsIgnoreCase(tenancyChain.getName()) && proctor.getLevel().equalsIgnoreCase(tenancyChain.getLevel())) {
                    proctorChains.add(tenancyChain);
                }
            }
        }
        return proctorChains;
    }

}

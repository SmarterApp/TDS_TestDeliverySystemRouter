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

package tds.router.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.saml.SAMLCredential;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import tds.router.generated.Proctor;
import tds.router.services.RouterConfigService;
import tds.router.stereotypes.CurrentUser;
import tds.router.util.TenancyChainHelper;

import java.util.List;

@Controller
public class ProctorController {

    private static final Logger logger = LoggerFactory.getLogger(ProctorController.class);

    @Autowired
    RouterConfigService routerConfigService;


    @RequestMapping("/proctor")
    public String landing(@CurrentUser SAMLCredential credential, Model model) {

        List<Proctor> proctorList = routerConfigService.getTdsRouteConfig().getProctor();

        //routeUser(credential);
        String zoneUrl = TenancyChainHelper.routeUser(credential, routerConfigService.getTdsRouteConfig());

        logger.info("Routing proctor user to: " + zoneUrl);
        return "redirect:" + zoneUrl;
    }


}

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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.saml.SAMLCredential;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import tds.router.services.RouterConfigService;
import tds.router.stereotypes.CurrentUser;
import tds.router.util.TenancyChainHelper;

@Controller
public class ProctorController {

    @Autowired
    RouterConfigService routerConfigService;


    @RequestMapping("/proctor")
    public String landing(@CurrentUser SAMLCredential credential) {

        String zoneUrl = TenancyChainHelper.routeUser(credential, routerConfigService.getTdsRouteConfig());

        return "redirect:" + zoneUrl;
    }


}

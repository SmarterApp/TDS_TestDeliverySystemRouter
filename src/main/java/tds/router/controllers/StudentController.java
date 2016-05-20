/*******************************************************************************
 * Educational Online Test Delivery System
 * Copyright (c) 2016 Regents of the University of California
 *
 * Distributed under the AIR Open Source License, Version 1.0
 * See accompanying file AIR-License-1_0.txt or at
 * http://www.smarterapp.org/documents/American_Institutes_for_Research_Open_Source_Software_License.pdf
 *
 * SmarterApp Open Source Assessment Software Project: http://smarterapp.org
 * Developed by Fairway Technologies, Inc. (http://fairwaytech.com)
 * for the Smarter Balanced Assessment Consortium (http://smarterbalanced.org)
 ******************************************************************************/

package tds.router.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tds.router.domain.StudentLogin;
import tds.router.services.RouterConfigService;
import tds.router.util.StudentRouteHelper;

@Controller
public class StudentController {

    private static final Logger logger = LoggerFactory.getLogger(ProctorController.class);

    @Autowired
    RouterConfigService routerConfigService;

    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public String studentLoginForm(Model model) {
        model.addAttribute("studentLogin", new StudentLogin());
        return "studentLogin";
    }

    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public String studentSubmit(@ModelAttribute StudentLogin studentLogin, Model model) {

        return "redirect:" +
                StudentRouteHelper.getStudentUrl(studentLogin, routerConfigService.getTdsRouteConfig().getZone());
    }

}

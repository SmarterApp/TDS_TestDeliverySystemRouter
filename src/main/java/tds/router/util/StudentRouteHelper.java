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
import tds.router.domain.StudentLogin;
import tds.router.generated.Zone;

import java.util.List;

public class StudentRouteHelper {

    private static final Logger logger = LoggerFactory.getLogger(StudentRouteHelper.class);

    private static final String STUDENT_ROUTER_PARAM = "routersession";

    public static String getStudentUrl(StudentLogin studentLogin, List<Zone> zones) {

        Zone targetZone = getTargetZone(studentLogin.getSessionPart1(), zones);

        String url = targetZone.getStudentUrl() + "?" + STUDENT_ROUTER_PARAM + "=" +
                studentLogin.getSessionPart1() + "-" +
                studentLogin.getSessionPart2() + "-" +
                studentLogin.getSessionPart3();

        return url;
    }

    public static Zone getTargetZone(String sessionPart1, List<Zone> zones) {

        String zoneKey = sessionPart1.substring(0, 1);
        logger.info("Student part1 {} has zone {} ", sessionPart1, zoneKey);

        Zone targetZone = zones.get(0);

        for (Zone z : zones) {
            if (z.getKey().equalsIgnoreCase(zoneKey)) {
                targetZone = z;
            }
        }

        logger.info(" Routing based on sessionPart1 {} to Zone Key: {} Zone Desc: {} ",
                sessionPart1,
                targetZone.getKey(),
                targetZone.getDescription());

        return targetZone;
    }

}

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

package tds.router.util;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import tds.router.generated.TdsRouteConfig;

import java.io.IOException;
import java.io.InputStream;

public class TenancyChainHelperTests {

    private static final String[] attributesSet1 = {
            "|OR|Reporting PII|STATE|98765|fairwaytech|||OR|OREGON|||||||||",
            "|orbendhs|Reporting PII|INSTITUTION|98765|fairwaytech|||OR|OREGON|||orbend001|BendDistrict|||orbendhs|BendHigh|",
            "|orbendhs|Test Admininistrator|INSTITUTION|98765|fairwaytech|||OR|OREGON|||orbend001|BendDistrict|||orbendhs|BendHigh|"};

    /*
    |districttA|District Coordinator|DISTRICT|98765|fairwaytech|||OR|OREGON|||districttA|A District|||||
    |districttA|Reporting PII|DISTRICT|98765|fairwaytech|||OR|OREGON|||districttA|A District|||||
     */

    @Test
    public void loadChainFromFile() throws IOException {

        ObjectMapper jsonMapper = new ObjectMapper();

        InputStream jsonStream =  ClassLoader.getSystemResourceAsStream("tdsRouteConfig.json");

        TdsRouteConfig tdsRouteConfig = jsonMapper.readValue(jsonStream, TdsRouteConfig.class);

        Assert.assertNotNull(tdsRouteConfig);

    }


}

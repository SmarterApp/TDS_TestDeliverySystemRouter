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

package tds.router.services.impl;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import tds.router.generated.TdsRouteConfig;
import tds.router.services.RouterConfigService;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;

/**
 * A service to load the routing configuration.  Defined as a JSON file.
 * Routing configuration is independent of application properties.
 */
@Service
public class RouterConfigServiceImpl implements RouterConfigService {

    @Value("${json.config.file:'tdsRouteConfig1.json'}")
    String jsonConfigFile;

    TdsRouteConfig tdsRouteConfig;

    @PostConstruct
    public void init() throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        InputStream jsonStream = ClassLoader.getSystemResourceAsStream("tdsRouteConfig.json");
        this.tdsRouteConfig = jsonMapper.readValue(jsonStream, TdsRouteConfig.class);
    }

    public TdsRouteConfig getTdsRouteConfig() {
        return tdsRouteConfig;
    }

}

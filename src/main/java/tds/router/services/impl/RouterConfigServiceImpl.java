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

package tds.router.services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import tds.router.config.TdsRouterProperties;
import tds.router.generated.TdsRouteConfig;
import tds.router.services.RouterConfigService;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * A service to load the routing configuration.  Defined as a JSON file.
 * Routing configuration is independent of application properties.
 */
@Service
@SuppressWarnings("Not Used")
public class RouterConfigServiceImpl implements RouterConfigService {

    @Autowired
    TdsRouterProperties tdsRouterProperties;

    private TdsRouteConfig tdsRouteConfig;

    @PostConstruct
    public void init() throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();

        File file = ResourceUtils.getFile(tdsRouterProperties.getRulesFile());
        FileReader fileReader = new FileReader(file);

        this.tdsRouteConfig = jsonMapper.readValue(fileReader, TdsRouteConfig.class);
    }

    public TdsRouteConfig getTdsRouteConfig() {
        return tdsRouteConfig;
    }

}

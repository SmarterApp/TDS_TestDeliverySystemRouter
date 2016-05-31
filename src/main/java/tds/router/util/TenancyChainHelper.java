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

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import org.springframework.security.saml.SAMLCredential;
import tds.router.domain.TenancyChain;
import tds.router.generated.TdsRouteConfig;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TenancyChainHelper {

    private static final String SBAC_TENANCY_ATTRIBUTE_NAME = "sbacTenancyChain";


    public static String routeUser(SAMLCredential credential, TdsRouteConfig tdsRouteConfig) {


        String[] tenancyNames = credential.getAttributeAsStringArray(SBAC_TENANCY_ATTRIBUTE_NAME);

        List<String> nameList = new ArrayList<String>(Arrays.asList(tenancyNames));

        getByStream(tenancyNames);

        //List<TenancyChain> chainList = createInsertsList(nameList);

        //Optional<TenancyChain> proctorChain = getFirstProctorTenancyChain(nameList);

        String fullUrl = tdsRouteConfig.getZone().get(0).getProctorUrl();
        return fullUrl;

    }


    public static java.util.function.Function<String, TenancyChain> tenancyChainFromSaml = new java.util.function.Function<String, TenancyChain>() {

        public TenancyChain apply(String t) {
            TenancyChain tenancyChain = new TenancyChain(t);
            return tenancyChain;
        }
    };

    public static List<TenancyChain> getByStream(String[] tnames) {

        String role = "Test Admininistrator";


        List<TenancyChain> tenancyChainList = Arrays.asList(tnames).stream()
                .map(tenancyChainFromSaml)
                .collect(Collectors.<TenancyChain>toList());

        return tenancyChainList;

    }


    // Return optional chain
    public static Optional<TenancyChain> getFirstProctorTenancyChain(List<String> nameList) {

        String role = "Test Admininistrator";

        Function<String, TenancyChain> transform = new Function<String, TenancyChain>() {
            @Override
            public TenancyChain apply(String input) {
                return new TenancyChain(input);
            }
        };

        Predicate<TenancyChain> predicate = new Predicate<TenancyChain>() {
            @Override
            public boolean apply(TenancyChain input) {
                return input != null && input.getName().equals(role);
            }
        };

        return FluentIterable
                .from(nameList)
                .transform(transform)
                .filter(predicate)
                .first();

    }


}

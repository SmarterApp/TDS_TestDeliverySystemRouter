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

package tds.router.domain;


public class StudentLogin {

    private String sessionPart1;
    private String sessionPart2;
    private String sessionPart3;

    public String getSessionPart1() {
        return sessionPart1;
    }

    public void setSessionPart1(String sessionPart1) {
        this.sessionPart1 = sessionPart1;
    }

    public String getSessionPart2() {
        return sessionPart2;
    }

    public void setSessionPart2(String sessionPart2) {
        this.sessionPart2 = sessionPart2;
    }

    public String getSessionPart3() {
        return sessionPart3;
    }

    public void setSessionPart3(String sessionPart3) {
        this.sessionPart3 = sessionPart3;
    }
}

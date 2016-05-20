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

import com.google.common.base.Splitter;

import java.util.List;

public class TenancyChain {

    private String roleID;
    private String name;
    private String level;
    private String clientID;
    private String client;
    private String groupOfStatesID;
    private String groupOfStates;
    private String stateID;
    private String state;
    private String groupOfDistrictsID;
    private String groupOfDistricts;
    private String districtID;
    private String district;
    private String groupOfInstitutionsID;
    private String groupOfInstitutions;
    private String institutionID;
    private String institution;

    public TenancyChain() {
    }

    public TenancyChain(String pipeTenancyChain) {

        List<String> chain = Splitter.on("|").trimResults().splitToList(pipeTenancyChain);
        this.roleID = chain.get(1);
        this.name = chain.get(2);
        this.level = chain.get(3);
        this.clientID = chain.get(4);
        this.client = chain.get(5);
        this.groupOfStatesID = chain.get(6);
        this.groupOfStates = chain.get(7);
        this.stateID = chain.get(8);
        this.state = chain.get(9);
        this.groupOfDistrictsID = chain.get(10);
        this.groupOfDistricts = chain.get(11);
        this.districtID = chain.get(12);
        this.district = chain.get(13);
        this.groupOfInstitutionsID = chain.get(14);
        this.groupOfInstitutions = chain.get(15);
        this.institutionID = chain.get(16);
        this.institution = chain.get(17);

    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getDistrictID() {
        return districtID;
    }

    public void setDistrictID(String districtID) {
        this.districtID = districtID;
    }

    public String getGroupOfDistricts() {
        return groupOfDistricts;
    }

    public void setGroupOfDistricts(String groupOfDistricts) {
        this.groupOfDistricts = groupOfDistricts;
    }

    public String getGroupOfDistrictsID() {
        return groupOfDistrictsID;
    }

    public void setGroupOfDistrictsID(String groupOfDistrictsID) {
        this.groupOfDistrictsID = groupOfDistrictsID;
    }

    public String getGroupOfInstitutions() {
        return groupOfInstitutions;
    }

    public void setGroupOfInstitutions(String groupOfInstitutions) {
        this.groupOfInstitutions = groupOfInstitutions;
    }

    public String getGroupOfInstitutionsID() {
        return groupOfInstitutionsID;
    }

    public void setGroupOfInstitutionsID(String groupOfInstitutionsID) {
        this.groupOfInstitutionsID = groupOfInstitutionsID;
    }

    public String getGroupOfStates() {
        return groupOfStates;
    }

    public void setGroupOfStates(String groupOfStates) {
        this.groupOfStates = groupOfStates;
    }

    public String getGroupOfStatesID() {
        return groupOfStatesID;
    }

    public void setGroupOfStatesID(String groupOfStatesID) {
        this.groupOfStatesID = groupOfStatesID;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getInstitutionID() {
        return institutionID;
    }

    public void setInstitutionID(String institutionID) {
        this.institutionID = institutionID;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStateID() {
        return stateID;
    }

    public void setStateID(String stateID) {
        this.stateID = stateID;
    }

    @Override
    public String toString() {
        return "TenancyChain{" +
                "client='" + client + '\'' +
                ", roleID='" + roleID + '\'' +
                ", name='" + name + '\'' +
                ", level='" + level + '\'' +
                ", clientID='" + clientID + '\'' +
                ", groupOfStatesID='" + groupOfStatesID + '\'' +
                ", groupOfStates='" + groupOfStates + '\'' +
                ", stateID='" + stateID + '\'' +
                ", state='" + state + '\'' +
                ", groupOfDistrictsID='" + groupOfDistrictsID + '\'' +
                ", groupOfDistricts='" + groupOfDistricts + '\'' +
                ", districtID='" + districtID + '\'' +
                ", district='" + district + '\'' +
                ", groupOfInstitutionsID='" + groupOfInstitutionsID + '\'' +
                ", groupOfInstitutions='" + groupOfInstitutions + '\'' +
                ", institutionID='" + institutionID + '\'' +
                ", institution='" + institution + '\'' +
                '}';
    }
}

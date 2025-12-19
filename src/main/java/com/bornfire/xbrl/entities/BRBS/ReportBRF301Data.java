package com.bornfire.xbrl.entities.BRBS;

import java.util.List;

public class ReportBRF301Data {
    
    private List<BRF301_entity> brf301_entity; // List to hold BRF301_entity objects

    // Getter method for accessing the list of BRF301_entity objects
    public List<BRF301_entity> getBrf301_entity() {
        return brf301_entity;
    }

    // Setter method for setting the list of BRF301_entity objects
    public void setBrf301_entity(List<BRF301_entity> brf301_entity) {
        this.brf301_entity = brf301_entity;
    }
}

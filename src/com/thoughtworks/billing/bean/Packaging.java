package com.thoughtworks.billing.bean;

/**
 * @see Item
 */
public enum Packaging {
    BOX("Box"),
    BOTTLE("Bottle"),
    PACKET("Packet"),
    NONE("");
    String description;


    Packaging(String description) {
        this.description = description;
    }


    String getDescription() {
        return description;
    }
}

package com.group4project.product;

import java.util.Locale;

public class ProductObject {
    private int productID;
    private String shortDescription;
    private double unitPrice;
    private int supplierId;
    private String countryName;
    private String productDescription;
    private String colour;
    private String size;

    public ProductObject(int productID, String shortDescription, double unitPrice, int supplierId, String productDescription, String colour, String size) {
        this.productID = productID;
        this.shortDescription = shortDescription;
        this.unitPrice = unitPrice;
        this.supplierId = supplierId;
        this.productDescription = productDescription;
        this.colour = colour;
        this.size = size;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public void setCountryNameFromIsoCode (String isoCode) {
        Locale locale = new Locale("",isoCode);
        setCountryName(locale.getDisplayName());
    }
}

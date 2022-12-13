package com.group4project.product;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import org.springframework.web.servlet.mvc.condition.ProducesRequestCondition;

import java.io.FileReader;
import java.util.Iterator;
import java.util.Map;

public class ReadFromJsonFile {
    public static ProductObject getProductObjectFromJsonFile() throws Exception {
        JSONParser parser = new JSONParser();
        FileReader fr = new FileReader("tempBlobFile.json");
        Object obj = parser.parse(fr);
        JSONObject jsonObject = (JSONObject) obj;

        int productId = (int) jsonObject.get("productId");
        String shortDescription = (String) jsonObject.get("shortDescription");
        double unitPrice = (double) jsonObject.get("unitPrice");

        Map productDetails = (Map) jsonObject.get("productDetails");
        int supplierId = (int) productDetails.get("supplierId");
        String isoCountryCode = (String) productDetails.get("isoCountryCode");
        String productDescription = (String) productDetails.get("productDescription");
        String colour = (String) productDetails.get("colour");
        String size = (String) productDetails.get("size");

        ProductObject productObject = new ProductObject(productId, shortDescription, unitPrice, supplierId, productDescription, colour, size);
        productObject.setCountryNameFromIsoCode(isoCountryCode);

        fr.close();
        return productObject;
    }
}

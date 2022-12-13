package com.group4project;

import com.google.gson.GsonBuilder;
import com.group4project.azureTools.AzureTools;
import com.group4project.product.ReadFromJsonFile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Files;
import java.nio.file.Path;

@RestController
public class ProductController {
    GsonBuilder gsonBuilder = new GsonBuilder().disableHtmlEscaping();
    @GetMapping(value = "/products/{id}/")
    public String getProduct(@PathVariable("id") String id) throws Exception {
        AzureTools.readBlobViaInputStream(id);
        if (Files.exists(Path.of("tempBlobFile.json"))){
            String productDetailsJSON = gsonBuilder.create().toJson(ReadFromJsonFile.getProductObjectFromJsonFile());
            Files.deleteIfExists(Path.of("tempBlobFile.json"));
            return productDetailsJSON;
        }
        return "The requested file could not be found. Please verify product ID is correct.";
    }
}

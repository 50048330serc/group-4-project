package com.group4project.azureTools;

import com.azure.storage.blob.*;
import com.azure.storage.blob.models.BlobItem;
import com.azure.storage.blob.specialized.BlobInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;

public class AzureTools {

    public static void readBlobViaInputStream(String id) {
        try {
            BlobServiceClient blobServiceClient = new BlobServiceClientBuilder()
                    .endpoint("https://asosuksnicohortstorage.blob.core.windows.net/cohort-4?sv=2021-10-04&st=2022-12-13T15%3A15%3A14Z&se=2022-12-17T15%3A15%3A00Z&sr=c&sp=rl&sig=SVqftsOlPwAhvTpeffgahq9jZ04Ei7I74ynPLY3pbgg%3D")
                    .sasToken("?sv=2021-10-04&st=2022-12-13T15%3A15%3A14Z&se=2022-12-17T15%3A15%3A00Z&sr=c&sp=rl&sig=SVqftsOlPwAhvTpeffgahq9jZ04Ei7I74ynPLY3pbgg%3D")
                    .buildClient();
            BlobContainerClient containerClient = blobServiceClient.getBlobContainerClient("cohort-4");


            for (BlobItem blobItem: containerClient.listBlobs()) {
                if (blobItem.getName().contains(id)){
                    BlobClient blobClient = containerClient.getBlobClient(blobItem.getName());
                    blobClient.downloadToFile("tempBlobFile.json");
                    System.out.println(blobItem.getName());
                    return;
                }
            }
            throw new FileNotFoundException();
        } catch (Exception e) {
            System.err.println("Failed - File does not exist");
        }
    }
}
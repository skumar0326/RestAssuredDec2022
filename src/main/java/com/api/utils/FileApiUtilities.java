package com.api.utils;

import io.restassured.response.Response;
import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Paths;

public final class FileApiUtilities {

    private FileApiUtilities(){}

    @SneakyThrows
    public static  String pathToGetJsonFromFile(String filePath){
      return new String( Files.readAllBytes(Paths.get(filePath)));
    }

    @SneakyThrows
    public static  void jsonToFile(String filePath, Response response){
           Files.write(Paths.get(filePath),response.asByteArray());
    }

    @SneakyThrows
    public static  String pathToGetSchemaFromFile(String filePath){
        return new String( Files.readAllBytes(Paths.get(filePath)));
    }


}

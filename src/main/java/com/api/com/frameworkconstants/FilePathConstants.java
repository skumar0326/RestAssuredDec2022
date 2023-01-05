package com.api.com.frameworkconstants;

import lombok.Getter;

public class FilePathConstants {


    private @Getter static  final String PROPERTIES_FILE_PATH =  System.getProperty("user.dir") + "/src/test/resources/";
    private @Getter static  final String JSON_REQUEST_FILE_PATH =  System.getProperty("user.dir") + "/src/test/resources/json/";
    private @Getter static  final String JSON_RESPONSE_FILE_PATH =  System.getProperty("user.dir") + "/outputfolder/";
    private @Getter static  final String JSON_Schema_FILE_PATH =  System.getProperty("user.dir") + "/src/test/resources/Schema/";

}

package com.api.com.api.properties;

import com.api.com.frameworkconstants.FilePathConstants;
import com.api.enu.PropertyType;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public final class ConfigProperties {

  private  static Properties prop = new Properties();
  private  static Map<String, String > MAP = new HashMap<>();

    static {


        try (FileInputStream fis = new FileInputStream(FilePathConstants.getPROPERTIES_FILE_PATH()+"config.properties")) {
                prop.load(fis);
            }   catch (IOException e) {
                e.printStackTrace();
                System.exit(0);
            }

            prop.entrySet().forEach(e -> MAP.put(String.valueOf(e.getKey()),(String.valueOf(e.getValue()))));
            System.out.println("it is called");
       // System.out.println(prop.getProperty("baseurl"));

      /*  for(Map.Entry<Object, Object> entries : prop.entrySet()){
         String key= String.valueOf(entries.getKey());
         String value =String.valueOf(entries.getValue());
         MAP.put(key,value);
        }*/
    }



    public static String getValue(PropertyType key){
        System.out.println(MAP.get(key.toString().toLowerCase()));
        return MAP.get(key.toString().toLowerCase());
    }

}
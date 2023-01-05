package com.api.utils;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;

public final class FakerUtils {

    private static final Faker faker = new Faker();
     private   FakerUtils(){}


       static int getId(int start,int end){
           return faker.number().numberBetween(start,end);
     }

       static String getFirstName(){
         return faker.name().firstName();
     }

      static String getLastName(){
        return faker.name().lastName();
    }


      static String getEmail(){
         return  RandomStringUtils.randomAlphabetic(5) + "@uk.com";
   }



}

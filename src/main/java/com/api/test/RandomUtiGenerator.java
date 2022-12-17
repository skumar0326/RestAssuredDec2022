package com.api.test;

public final class RandomUtiGenerator {
    // business layer
    private RandomUtiGenerator(){}

    public static int getId(){
        return FakerUtils.getId(200,500);
    }

    public static String getFName(){
        return FakerUtils.getFirstName();
    }

    public static String getLName(){
        return FakerUtils.getLastName();
    }

    public static String getEmail(){
        return FakerUtils.getEmail();
    }
}

package com.api.Report;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public final class ExtentReport {

    private ExtentReport(){
    }

    private static   ExtentReports  reports;
    private static  ExtentTest extentTest;

    public   static  void init_reports(){
          reports = new ExtentReports();
          ExtentSparkReporter sparkReporter = new ExtentSparkReporter("target/Spark/Spark.html");
          reports.attachReporter(sparkReporter);
    }

      public static  void create_Report(String methodName){

        extentTest = reports.createTest(methodName);
    }

     public static ExtentTest getExtentTest() {
        return extentTest;
    }



       public static void  flushReport(){
        reports.flush();
    }


    public static  void  addAuthor(String[] authors){
        for (String author : authors){
            getExtentTest().assignAuthor(author);
        }
    }


    public static  void  addCategory(String[] categories){
        for (String category : categories){
            getExtentTest().assignCategory(category);
        }
    }


    public static  void  addDevice(String[] devices) {
        for (String device : devices) {
            getExtentTest().assignDevice(device);
        }
    }
}

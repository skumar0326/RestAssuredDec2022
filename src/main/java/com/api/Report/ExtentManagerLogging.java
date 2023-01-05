package com.api.Report;

import static com.api.Report.ExtentReport.*;

import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;

public class ExtentManagerLogging {


    public static void  passed(String msg){
        getExtentTest().pass(msg);
    }

    public static void  failed(String msg){
      getExtentTest().fail(MarkupHelper.createLabel(msg, ExtentColor.RED));
    }

    public static  void  info(String message){
        getExtentTest().info(message);
    }

    public static  void  logResponse(String code){
        getExtentTest().info(MarkupHelper.createCodeBlock(code, CodeLanguage.JSON));
    }

    public static  void  logRequest(RequestSpecification requestSpecification){
        QueryableRequestSpecification query = SpecificationQuerier.query(requestSpecification);
        info("Request Details below");
        getExtentTest().info(MarkupHelper.createCodeBlock(query.getBody(),CodeLanguage.JSON));
        for (Header header : query.getHeaders()){
            info(header.getName() + " : " +  header.getValue() );
        }

    }






}

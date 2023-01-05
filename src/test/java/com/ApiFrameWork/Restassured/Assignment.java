package com.ApiFrameWork.Restassured;

import RequestBuilder.ApiUtils;
import com.api.Report.ExtentReport;
import com.api.annotations.FrameworkAnnotation;
import com.api.com.frameworkconstants.FilePathConstants;
import com.api.pojo.Employee;
import com.api.pojo.Jobs;
import com.api.utils.FileApiUtilities;
import com.api.utils.RandomUtiGenerator;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.Arrays;

import static RequestBuilder.ApiUtils.getRequestBuilder;
import static RequestBuilder.ApiUtils.updateRequestBuilder;

public class Assignment {

   @Test
   @FrameworkAnnotation(authors = {"Shirish"}, category = {"Test1", "integration"}, device = {"Desktop"})

   public void assignmentTest(){

        int size = ApiUtils.getRequestBuilder().get("/employees").jsonPath().getList("$").size();


       Jobs  job =Jobs.builder().designation("london").location("guil")
               .responsibilities(Arrays.asList("manager","organizing")).build();


       Employee employee = Employee.builder().email(RandomUtiGenerator.getEmail())
               .id(RandomUtiGenerator.getId())
               .first_name(RandomUtiGenerator.getFName())
               .last_name(RandomUtiGenerator.getLName())
               .foods(Arrays.asList("chapathi" ,"curry"))
               .jobs(job)
               .build();


       Response  responseBody = ApiUtils.postRequestBuilder().body(employee).post("/employees");
        ExtentReport.getExtentTest().log(Status.PASS , MarkupHelper.createCodeBlock(responseBody.asPrettyString(), CodeLanguage.JSON));

        //validating schema
        responseBody.then().body(JsonSchemaValidator.matchesJsonSchema(FileApiUtilities.
        pathToGetSchemaFromFile(FilePathConstants.getJSON_Schema_FILE_PATH()+ "employee.json" )));


        // checking the size
       Assertions.assertThat(getRequestBuilder().get("/employees").jsonPath().getList("$").size()).isEqualTo(size+1);


      //updating the request
      int id = employee.getId() ;
       System.out.println("id is -----------" + id );
       employee.setFirst_name("default shirish");

       Response putResponse = updateRequestBuilder().pathParam("id", id).body(employee).put("/employees/{id}");
       FileApiUtilities.jsonToFile(FilePathConstants.getJSON_RESPONSE_FILE_PATH() + "employeeResponse.json" ,putResponse);

       updateRequestBuilder().pathParam("id",id).body(employee).delete("/employees/{id}");

       Assertions.assertThat(getRequestBuilder().get("/employees").jsonPath().getList("$").size()).isEqualTo(size);





   }



}

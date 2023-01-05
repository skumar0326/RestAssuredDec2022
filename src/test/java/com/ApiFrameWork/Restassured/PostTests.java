package com.ApiFrameWork.Restassured;

import com.api.Report.ExtentManagerLogging;
import com.api.Report.ExtentReport;
import com.api.annotations.FrameworkAnnotation;
import com.api.com.frameworkconstants.FilePathConstants;
import com.api.pojo.Employee;
import com.api.pojo.Jobs;
import RequestBuilder.ApiUtils;
import com.api.utils.FileApiUtilities;
import com.api.utils.RandomUtiGenerator;

import static org.assertj.core.api.Assertions.*;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class PostTests  extends  BaseClass{

    @Test
    @FrameworkAnnotation(authors = {"Shirish"}, category = {"Test1", "integration"}, device = {"Desktop"})
    public void  testPostRequest(Method method){

        System.out.println("Test Case two with Thread Id:- "
                + Thread.currentThread().getId() +    method.getName());

     /*Employee employee = Employee.builder()
                .id(new Faker().number().numberBetween(200,300))
                .fName("myname")
                .lName("lastname")
                .email("somemail")
                .build();
*/

     /* Employee employee = Employee.builder()
              .id(new Faker().number().numberBetween(200,300))
              .fName("kkk")
              .lName("llll")
              .email("email@.com")
              .foods(Arrays.asList("Chappati","bread"))
              .job(new jobs("manager","london",Arrays.asList("teaching","reporting","meetings")))
              .build();
*/

       // Having a variable  which is of a class type,you need to give annotation @Allargumentconstructor on the class level for that class
       //so that we can add the   variable  in the constructor as below (Jobs jobs)
        Employee employee = Employee.builder()
                .id(RandomUtiGenerator.getId())
                .first_name(RandomUtiGenerator.getFName())
                .last_name(RandomUtiGenerator.getLName())
                .email(RandomUtiGenerator.getEmail())
                .foods(Arrays.asList("Chappati","bread"))
                .jobs(new Jobs( "manager","london",Arrays.asList("teaching","reporting","meetings")))
                .build();


       //sending a request
        Response response = ApiUtils.postRequestBuilder()
                            .body(employee)
                            .post("/employees");

        Employee emp = response.as(Employee.class);
        List<String> foods = emp.getFoods();
            for (String fo :foods){
                System.out.println(fo);
            }

         // emp.getFoods().containsAll(Arrays.asList("chappati", "bread")

                System.out.println("------------------------------------------------------");
           assertThat(emp.getFoods().containsAll(Arrays.asList("chappati","bread")));
        ExtentManagerLogging.logResponse(response.asPrettyString());

    }




    @Test
    @FrameworkAnnotation(authors = {"Kumar"}, category = {"Staging", "integration"}, device = {"laptop"})
    public void postRequestFromExternalFile(Method method){

        System.out.println("Test Case two with Thread Id:- "
                + Thread.currentThread().getId() + method.getName());
     String request =   FileApiUtilities.pathToGetJsonFromFile(FilePathConstants.getJSON_REQUEST_FILE_PATH()+"request.json")
                .replace("number" , String.valueOf(RandomUtiGenerator.getId()))
                .replace("fname",RandomUtiGenerator.getFName()); //Arrange


     RequestSpecification requestSpecification = ApiUtils.postRequestBuilder()
                .body(request);
       ExtentManagerLogging.logRequest(requestSpecification);

       Response response=requestSpecification.post("/employees");   //Actions
        ExtentManagerLogging.logResponse(response.asPrettyString());
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");


           

         assertThat(response.getStatusCode()).isEqualTo(201); // Assertions

        // Copy the response back to file
        FileApiUtilities.jsonToFile(FilePathConstants.getJSON_RESPONSE_FILE_PATH()+"response.json",response);

        System.out.println(FilePathConstants.getJSON_REQUEST_FILE_PATH()+"request.json");

   }


}

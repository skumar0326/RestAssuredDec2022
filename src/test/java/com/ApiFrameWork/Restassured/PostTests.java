package com.ApiFrameWork.Restassured;

import com.api.com.frameworkconstants.FilePathConstants;
import com.api.pojo.Employee;
import com.api.pojo.jobs;
import RequestBuilder.ApiUtils;
import com.api.test.ApiUtilities;
import com.api.test.RandomUtiGenerator;

import static org.assertj.core.api.Assertions.*;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class PostTests {

    @Test
    public void  testPostRequest(){

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
                .jobs(new jobs( "manager","london",Arrays.asList("teaching","reporting","meetings")))
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
            assertThat(emp.getFoods().containsAll(Arrays.asList("chappati","bread")));
    }

    @Test
    public void postRequestFromExternalFile(){
     String request =   ApiUtilities.pathToGetJsonFromFile(FilePathConstants.getJSON_REQUEST_FILE_PATH()+"request.json")
                .replace("number" , String.valueOf(RandomUtiGenerator.getId()))
                .replace("fname",RandomUtiGenerator.getFName()); //Arrange


     Response response = ApiUtils.postRequestBuilder()
                .body(request)
                .post("/employees");   //Actions

        assertThat(response.getStatusCode()).isEqualTo(201); // Assertions
        ApiUtilities.jsonToFile(FilePathConstants.getJSON_RESPONSE_FILE_PATH()+"response.json",response);
        System.out.println(FilePathConstants.getJSON_REQUEST_FILE_PATH()+"request.json");

   }


}

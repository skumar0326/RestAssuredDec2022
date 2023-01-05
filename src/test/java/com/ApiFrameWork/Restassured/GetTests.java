package com.ApiFrameWork.Restassured;

import RequestBuilder.ApiUtils;
import com.api.Report.ExtentManagerLogging;
import com.api.annotations.FrameworkAnnotation;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import java.lang.reflect.Method;
import static org.assertj.core.api.Assertions.assertThat;

public class GetTests  {




@Test
@FrameworkAnnotation(authors = {"Shirish"}, category = {"smoke", "integration"}, device = {"mobile"})
public void getRequest(Method method){

     // ExtentReporting.getExtentTest().assignAuthor("Shirish").assignCategory("smoke").assignDevice("windows");

      /*System.out.println("Test Case two with Thread Id:- "
              + Thread.currentThread().getId() + method.getName());*/

      Response response = ApiUtils
        .getRequestBuilder()
        .get("/employees")
    ;
      if (response.statusCode() == 200) {
         /* ExtentReporting.getExtentTest().pass(
                  MarkupHelper.createCodeBlock(response.asPrettyString(), CodeLanguage.JSON));
*/
           ExtentManagerLogging.info("Respone code is " +String.valueOf(response.statusCode()));
      }


      assertThat(response.getStatusCode()).isEqualTo(200);
       assertThat(response.jsonPath().getList("$")).size().isPositive()
           .as("validating the size of employee array").isGreaterThan(30);
   //   assertThat(response.jsonPath().get("[5].id")).as("if id not equal")

}






}

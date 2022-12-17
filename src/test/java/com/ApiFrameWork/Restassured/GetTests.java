package com.ApiFrameWork.Restassured;

import RequestBuilder.ApiUtils;
import io.restassured.response.Response;

import static org.assertj.core.api.Assertions.*;
import org.testng.annotations.Test;

public class GetTests {

@Test
public void getRequest(){
Response response = ApiUtils
        .getRequestBuilder()
        .get("/employees")
    ;
      assertThat(response.getStatusCode()).isEqualTo(200);
      assertThat(response.jsonPath().getList("$")).size().isPositive()
              .as("validating the size of employee array").isGreaterThan(30);
   //   assertThat(response.jsonPath().get("[5].id")).as("if id not equal")

}






}

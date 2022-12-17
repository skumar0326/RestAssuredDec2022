package RequestBuilder;

import com.api.com.api.properties.ConfigProperties;
import com.api.enu.PropertyType;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;

public final class ApiUtils { //Dont want other calls to extend

    private ApiUtils(){

    }


    public static RequestSpecification getRequestBuilder(){

     return   given()
        .log()
        .all()
        .baseUri(ConfigProperties.getValue(PropertyType.BASEURL));


    }



    public static RequestSpecification postRequestBuilder(){
        return   given()
                .log()
                .all()
                .header("Content-Type" , ContentType.JSON)
                .baseUri(ConfigProperties.getValue(PropertyType.BASEURL));
    }


}

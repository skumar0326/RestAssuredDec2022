package RequestBuilder;

import com.api.com.api.properties.ConfigProperties;
import com.api.enums.PropertyType;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public final class ApiUtils { //Dont want other calls to extend

    private ApiUtils(){

    }


    public static RequestSpecification getRequestBuilder(){
     return     given()
                .log()
                .all()
                .baseUri(ConfigProperties.getValue(PropertyType.BASEURL));
    }



    public static RequestSpecification postRequestBuilder(){
        return   given()
                .log()
                .all()
                .header("Content-Type" , ContentType.JSON)
                .accept("application/json")
                .baseUri(ConfigProperties.getValue(PropertyType.BASEURL));

    }


    public static RequestSpecification updateRequestBuilder(){
        return   given()
                .log()
                .all()
                .header("Content-Type" , ContentType.JSON)
                .accept("application/json")
                .baseUri(ConfigProperties.getValue(PropertyType.BASEURL));

    }

}

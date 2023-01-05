package authentication;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.awt.*;

import  static  io.restassured.RestAssured.*;

public class AuthenAndAuthorisation {


@Test
public void authentication(){
     Response response = given()
           .accept("application/vnd.github+json")

              .header("Authorization","Bearer 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")
             .queryParam("per_page" ,1)
              .log()
              .all()
              .get("https://api.github.com/user/repos")
              ;

     String s = response.asPrettyString();
     System.out.println(s);

     Object o = response.jsonPath().get("[0].id");
     System.out.println(0);

     Dimension screenResolution = Toolkit.getDefaultToolkit().getScreenSize();
     System.out.println(screenResolution .getHeight() + "----->"+ screenResolution.getWidth()+  "---------------");

   /*  String s = response.getBody().asString();


     System.out.println("response is" + s );*/

}


 @Test
 public void createNewRepositry(){

             given()
             .accept("application/vnd.github+json")
             .header("Authorization","Bearer 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")
              .body(" {\"name\":\"Hello-World from intelliji\",\n" +
                      " \"description\":\"This is your first repo!\",\n" +
                      " \"homepage\":\"https://github.com\",\"private\":false,\n" +
                      " \"is_template\":true\n" +
                      " \n" +
                      " }\n")
                     .post("https://api.github.com/user/repos")
                     .asPrettyString();






 }

}

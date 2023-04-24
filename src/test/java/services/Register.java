package services;

import static io.restassured.RestAssured.*;

import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import utilities.ConfigurationReader;

import java.util.HashMap;
import java.util.Map;

public class Register {

Response response;
Faker faker =new Faker();
String email;
String firstName;
String lastName;
String linkedIn;


public void registerRequest(){

    /*
{
  "confirmPassword": "Test123456!",
  "disabled": true,
  "email": "ayazilitas@gmail.com",
  "firstName": "Lion",
  "gdpr": true,
  "lastName": "Writittenstone",
  "linkedIn": "linkedin.com/in/writtenstone22",
  "password": "Test123456!"
}
 */

    String confirmPassword= ConfigurationReader.get("commonPassword");
    Boolean disabled= true;
    email=faker.internet().emailAddress();
    firstName=faker.name().firstName();
    Boolean gdpr= true;
    lastName=faker.name().lastName();
    linkedIn="linkedin.com/in/"+firstName+lastName;
    String password= confirmPassword;


    Map<String,Object>body= new HashMap<>();
    body.put("confirmPassword",confirmPassword);
    body.put("disabled",disabled);
    body.put("email",email);
    body.put("firstName",firstName);
    body.put("gdpr",gdpr);
    body.put("lastName",lastName);
    body.put("linkedIn",linkedIn);
    body.put("password",password);




    response= given().
            contentType(ContentType.JSON).
            body(body).log().all().
            post("auth/register").prettyPeek();

}

    public void verifyStatusCode(int statucode){

        Assert.assertEquals(statucode,response.statusCode());
    }





}

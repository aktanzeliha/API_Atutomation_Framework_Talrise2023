package step_Defs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.RestAssured;
import utilities.ConfigurationReader;

public class Hooks {

    @Before
    public void setUp(){
        RestAssured.baseURI= ConfigurationReader.get("url");
    }

    @After
    public void tearDown(){
        RestAssured.reset();
    }
}

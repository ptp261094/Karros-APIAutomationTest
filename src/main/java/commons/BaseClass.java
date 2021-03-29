package commons;

import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;

public class BaseClass {

    @BeforeSuite
    public static void init() {
    	
    	RestAssured.baseURI = "https://my-json-server.typicode.com";
        RestAssured.basePath = "/typicode/demo/posts";
        
    }
}

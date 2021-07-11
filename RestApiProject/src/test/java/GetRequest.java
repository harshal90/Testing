import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetRequest {

 @Test
 public void getIpAddress() {

  
  RestAssured.baseURI = "http://httpbin.org/ip";

  Response response = null;

  try {
   response = RestAssured.given()
    .when()
    .get();
  } catch (Exception e) {
   e.printStackTrace();
  }

  assertEquals(200, response.getStatusCode());
  System.out.println("Response :" + response.asString());
  System.out.println("Status Code :" + response.getStatusCode());
  System.out.println("Does Reponse contains 'ipaddress'? :" + response.asString().contains("83.81.253.64"));



 }
}
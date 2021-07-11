import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class BasicAuthenticationTest {

    @Test
    public void auth() {

        RestAssured.baseURI = "http://httpbin.org/basic-auth";

        Response response = null;

        

        try {
         response = RestAssured.given()
        		 .auth().basic("admin", "powd")
          .when()
          .get("/admin/pwd");
        } catch (Exception e) {
         e.printStackTrace();
        }

        System.out.println("Response :" + response.asString());
        System.out.println("Status Code :" + response.getStatusCode());
      

        assertEquals(200, response.getStatusCode());
    }
}
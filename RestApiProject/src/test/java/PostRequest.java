import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostRequest {

    @Test
    public void post() {

        RestAssured.baseURI = "http://httpbin.org";

        String requestBody = "{\r\n"
        		+ "\"data\": \"Test Irdeto\"\r\n"
        		+ "}";


        Response response = null;

        try {
            response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post("/post");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Response :" + response.asString());
        System.out.println("Status Code :" + response.getStatusCode());
        System.out.println("Does Reponse contains 'Test Irdeto'? :" + response.asString().contains("Test Irdeto"));


        assertEquals(200, response.getStatusCode());
    }
}
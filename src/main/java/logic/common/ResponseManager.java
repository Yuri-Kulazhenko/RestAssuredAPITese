package logic.common;
import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;
public class ResponseManager {

    public Response getResponse(String URI, Map<String, String> headers, Map<String, String> queryParams ){
        return given()
                .headers(headers)
                .queryParams(queryParams)
                .log().all()
                .when()
                .get(URI)
                .then()
                .log().all()
                .extract().response();
    }
}

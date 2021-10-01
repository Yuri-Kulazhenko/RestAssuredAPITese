package tests.football;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import logic.common.ResponseManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;
import static logic.common.AuthData.BASIC_USER;
import static logic.common.EndPoints.GET_SEARCH_COUNTRIES;
import static logic.constans.HedersLabels.RAPIDAPI_HOST;
import static logic.constans.HedersLabels.RAPIDAPI_KEY;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SearchCountryTest extends ResponseManager{
    Map<String, String> headers = new HashMap<>();

    @BeforeClass
    public void install(){
        RestAssured.baseURI = "https://api-football-v1.p.rapidapi.com";
        RestAssured.basePath = "/v3";
        headers.put(RAPIDAPI_HOST.get(), BASIC_USER.getHost());
        headers.put(RAPIDAPI_KEY.get(), BASIC_USER.getKey());
    }

    @AfterClass
    public void clean(){
    }

    @Test
    public void test001_SearchCountry(){

        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("name","France");
        queryParams.put("code","FR");
        queryParams.put("search","FRA");

        Response response = getResponse(GET_SEARCH_COUNTRIES.get(),  headers,  queryParams);

        HashMap countryInfo = null;
        try {
            countryInfo = new ObjectMapper().readValue(response.getBody().asString(), HashMap.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        assert countryInfo != null;
        assertThat(countryInfo.toString().contains("France") , is (true));

    }

    @Test
    public void test002_SearchCountry(){

        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("name","France");
        queryParams.put("code","");
        queryParams.put("search","");

        Response response = getResponse(GET_SEARCH_COUNTRIES.get(),  headers,  queryParams);

        HashMap countryInfo = null;
        try {
            countryInfo = new ObjectMapper().readValue(response.getBody().asString(), HashMap.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        assert countryInfo != null;
        assertThat(countryInfo.toString().contains("FR") , is (true));

    }
}

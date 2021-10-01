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
import static logic.common.EndPoints.GET_SEARCH_TEAM;
import static logic.constans.HedersLabels.RAPIDAPI_HOST;
import static logic.constans.HedersLabels.RAPIDAPI_KEY;
import static logic.constans.SearchTeamParams.SEARCH;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SearchTeamTest extends ResponseManager {
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
    public void test001_SearchTeamWithValidData(){

        Map<String, String> queryParams = new HashMap<>();
        queryParams.put(SEARCH.get(), "Italy");

        Response response = getResponse(GET_SEARCH_TEAM.get(),  headers,  queryParams);

        HashMap teamInfo = null;
        try {
            teamInfo = new ObjectMapper().readValue(response.getBody().asString(), HashMap.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        assert teamInfo != null;
        assertThat(teamInfo.toString().contains("Stadio Giuseppe Meazza") , is (true));

    }

    @Test
    public void test002_SearchTeamWithInvalidData(){

        Map<String, String> queryParams = new HashMap<>();
        queryParams.put(SEARCH.get(), "br");

        Response response = getResponse(GET_SEARCH_TEAM.get(),  headers,  queryParams);

        HashMap <String,Object>teamInfo = null;
        try {
            teamInfo = new ObjectMapper().readValue(response.getBody().asString(), HashMap.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(teamInfo.toString());


        assert teamInfo != null;
        assertThat(teamInfo.toString().contains("Stadio Giuseppe Meazza ") , is (true));

    }

}

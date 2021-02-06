package hw_api_2.service;

import hw_api_2.dto.CheckTextResponseDto;
import hw_api_2.utils.PropertiesWorking;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.SneakyThrows;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;

import java.util.Map;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class CommonService {

    private RequestSpecification REQUEST_SPECIFICATION;

    public CommonService() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        REQUEST_SPECIFICATION = new RequestSpecBuilder()
                .setBaseUri(PropertiesWorking.getProperty("baseUrl"))
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();
    }

//    public Response getTextNoParams(String uri, String text) {
//        Response response = given(REQUEST_SPECIFICATION)
//                .queryParam("text", text)
//                .get(uri)
//                .then().statusCode(Matchers.greaterThanOrEqualTo(HttpStatus.SC_OK))
//                .extract().response()
//                .then().statusCode(Matchers.lessThan(HttpStatus.SC_MULTIPLE_CHOICES))
//                .log().all()
//                .extract().response();
//        return response;
//    }

    public Response getTextWithParams(String uri, Map<String, Object> params) {
        RequestSpecification specification = given(REQUEST_SPECIFICATION);

        for (Map.Entry<String, Object> param : params.entrySet())
            specification.param(param.getKey(), param.getValue());

        return specification.get(uri);
    }
}

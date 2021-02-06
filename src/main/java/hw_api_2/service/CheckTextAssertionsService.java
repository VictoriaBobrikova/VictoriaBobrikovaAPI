package hw_api_2.service;

import com.google.gson.Gson;
import hw_api_2.dto.CheckTextRequestDto;
import hw_api_2.dto.CheckTextResponseDto;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;

import java.util.HashMap;
import java.util.Map;

import static org.testng.AssertJUnit.assertEquals;

public class CheckTextAssertionsService extends CommonService{

    private String responseActual;

    public void verifyWrongWord(CheckTextRequestDto request,
                                        CheckTextResponseDto[] response) {
        if (response.length != 0) {
            responseActual = response[0].getWord();
        }
        else responseActual = "";
        assertEquals(request.getWrongWord(), responseActual);
    }

    public void verifyResponseText(CheckTextRequestDto request,
                                   CheckTextResponseDto[] response) {
        if (response.length != 0) {
            responseActual = response[0].getS().get(0);
        }
        else responseActual = "";
        assertEquals(request.getExpectedWord(), responseActual);
    }

    public void verifyResponseErrorCode(CheckTextRequestDto request,
                                        CheckTextResponseDto[] response) {
        if (response.length != 0) {
            responseActual = response[0].getCode();
        }
        else responseActual = "";
        assertEquals(request.getExpectedCode(), responseActual);
    }

    public void verifyStatusCode(CheckTextRequestDto request) {
        Map<String, Object> params = new HashMap<>();
        params.put("text", request.getText());
        params.put("lang", request.getLang());
        params.put("options", request.getOptions());
        new CheckTextService().getTextWithParams(URI.CHECK_TEXT, params)
                .then()
                .assertThat().statusCode(Matchers.greaterThanOrEqualTo(HttpStatus.SC_OK))
                .and()
                .extract().response()
                .then().assertThat().statusCode(Matchers.lessThan(HttpStatus.SC_MULTIPLE_CHOICES));
    }
}
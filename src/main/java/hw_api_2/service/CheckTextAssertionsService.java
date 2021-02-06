package hw_api_2.service;

import hw_api_2.dto.CheckTextRequestDto;
import hw_api_2.dto.CheckTextResponseDto;

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
}

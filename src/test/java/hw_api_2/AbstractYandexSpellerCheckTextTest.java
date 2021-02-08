package hw_api_2;

import hw_api_2.dto.CheckTextRequestDto;
import hw_api_2.dto.CheckTextResponseDto;
import hw_api_2.service.CheckTextAssertionsService;
import hw_api_2.service.CheckTextService;
import hw_api_2.utils.PropertiesWorking;
import org.testng.annotations.BeforeClass;

public class AbstractYandexSpellerCheckTextTest {

    protected CheckTextService checkTextService;
    protected CheckTextAssertionsService checkTextAssertionsService;

    @BeforeClass
    public void setUp() {
        PropertiesWorking.getFromPropertiesFile("./src/test/resources/test.properties");
        checkTextService = new CheckTextService();
        checkTextAssertionsService = new CheckTextAssertionsService();
    }

    public void verifyResponse(CheckTextRequestDto request) {
        CheckTextResponseDto[] response = checkTextService.checkTextWithParams(request);
        checkTextAssertionsService.verifyWrongWord(request, response);
        checkTextAssertionsService.verifyResponseText(request, response);
        checkTextAssertionsService.verifyResponseErrorCode(request, response);
        checkTextAssertionsService.verifyStatusCode(request);
    }
}

package hw_api_2;

import hw_api_2.dataProvider.YandexSpellerDataProvider;
import hw_api_2.dto.CheckTextRequestDto;
import hw_api_2.dto.CheckTextResponseDto;
import org.testng.annotations.Test;

public class YandexSpellerCheckTextTest extends AbstractYandexSpellerCheckTextTest {

    @Test(dataProvider = "checkTextNoOptionsDataSet",dataProviderClass = YandexSpellerDataProvider.class)
    public void checkTextNoOptionsTest(CheckTextRequestDto request) {
        verifyResponse(request);
    }

    @Test(dataProvider = "checkTextIgnoreDigitsDataSet",dataProviderClass = YandexSpellerDataProvider.class)
    public void checkTextIgnoreDigitsTest(CheckTextRequestDto request) {
        verifyResponse(request);
    }

    @Test(dataProvider = "checkTextIgnoreCapitalizationDataSet",dataProviderClass = YandexSpellerDataProvider.class)
    public void checkTextIgnoreCapitalizationTest(CheckTextRequestDto request) {
        verifyResponse(request);
    }

    @Test(dataProvider = "checkTextFindRepeatWordsDataSet",dataProviderClass = YandexSpellerDataProvider.class)
    public void checkTextFindRepeatWordsTest(CheckTextRequestDto request) {
        CheckTextResponseDto[] response = checkTextService.checkTextWithParams(request);
        checkTextAssertionsService.verifyWrongWord(request, response);
        checkTextAssertionsService.verifyResponseErrorCode(request, response);
        checkTextAssertionsService.verifyStatusCode(request);
    }

    @Test(dataProvider = "checkTextCapitalizationErrorDataSet", dataProviderClass = YandexSpellerDataProvider.class)
    public void checkTextCapitalizationErrorTest(CheckTextRequestDto request) {
        verifyResponse(request);
    }

}
package hw_api_2.dataProvider;

import hw_api_2.dto.CheckTextRequestDto;
import hw_api_2.utils.JsonFileDataReading;
import org.testng.annotations.DataProvider;

import java.util.List;

public class YandexSpellerDataProvider {

    private static final String checkTextNoOptionsPath = "src/test/resources/testData/checkTextNoOptions.json";
    private static final String checkTextIgnoreDigitsPath = "src/test/resources/testData/checkTextIgnoreDigits.json";
    private static final String checkTextIgnoreCapitalizationPath = "src/test/resources/testData/checkTextIgnoreCapitalization.json";
    private static final String checkTextFindRepeatWordsPath = "src/test/resources/testData/checkTextFindRepeatWords.json";
    private static final String checkTextCapitalizationErrorPath = "src/test/resources/testData/checkTextCapitalizationError.json";

    @DataProvider
    public Object[] checkTextNoOptionsDataSet() {
        List<CheckTextRequestDto> list = JsonFileDataReading.readJson(checkTextNoOptionsPath);
        return list.toArray();
    }

    @DataProvider
    public Object[] checkTextIgnoreDigitsDataSet() {
        List<CheckTextRequestDto> list = JsonFileDataReading.readJson(checkTextIgnoreDigitsPath);
        return list.toArray();
    }

    @DataProvider
    public Object[] checkTextIgnoreCapitalizationDataSet() {
        List<CheckTextRequestDto> list = JsonFileDataReading.readJson(checkTextIgnoreCapitalizationPath);
        return list.toArray();
    }

    @DataProvider
    public Object[] checkTextFindRepeatWordsDataSet() {
        List<CheckTextRequestDto> list = JsonFileDataReading.readJson(checkTextFindRepeatWordsPath);
        return list.toArray();
    }

    @DataProvider
    public Object[] checkTextCapitalizationErrorDataSet() {
        List<CheckTextRequestDto> list = JsonFileDataReading.readJson(checkTextCapitalizationErrorPath);
        return list.toArray();
    }
}
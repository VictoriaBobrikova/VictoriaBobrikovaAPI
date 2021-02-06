package hw_api_2.service;

import com.google.gson.Gson;
import hw_api_2.dto.CheckTextRequestDto;
import hw_api_2.dto.CheckTextResponseDto;

import java.util.HashMap;
import java.util.Map;

public class CheckTextService extends CommonService {

    public CheckTextResponseDto[] checkTextWithParams(CheckTextRequestDto request) {
        Map<String, Object> params = new HashMap<>();
        params.put("text", request.getText());
        params.put("lang", request.getLang());
        params.put("options", request.getOptions());
        return
                new Gson().fromJson(
                        new CommonService()
                                .getTextWithParams(URI.CHECK_TEXT, params)
                                .getBody().asString(), CheckTextResponseDto[].class);
    }
}
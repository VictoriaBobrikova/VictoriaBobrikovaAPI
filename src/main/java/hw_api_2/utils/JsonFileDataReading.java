package hw_api_2.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import hw_api_2.dto.CheckTextRequestDto;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonFileDataReading {

    public static List<CheckTextRequestDto> readJson(String filePath) {

        List<CheckTextRequestDto> listCheckTextRequestDto = new ArrayList<>();

        try {
            ObjectMapper mapper = new ObjectMapper();
            FileInputStream fis = new FileInputStream(filePath);

            HashMap<String, CheckTextRequestDto> map = mapper.readValue(fis,
                    new TypeReference<HashMap<String, CheckTextRequestDto>>() {});

            for(Map.Entry<String, CheckTextRequestDto> entry : map.entrySet()){
                listCheckTextRequestDto.add(entry.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listCheckTextRequestDto;
    }
}

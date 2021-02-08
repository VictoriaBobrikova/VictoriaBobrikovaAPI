package hw_api_2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class CheckTextRequestDto {

    private String text;
    private String lang;
    private String options;
    private String format;
    private String expectedCode;
    private String expectedWord;
    private String wrongWord;
}
package hw_api_2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CheckTextResponseDto {

    private String code;
    private String pos;
    private String row;
    private String col;
    private String len;
    private String word;
    private ArrayList<String> s;
}

package team8.nugu.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class IntroResDTO {
    private String keyword1;
    private String keyword2;
    private String keyword3;
    private List<String> intro_list = new ArrayList<String>();
}

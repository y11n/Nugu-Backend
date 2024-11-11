package team8.nugu.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TestRequestDto {
    private List<String> answers;

    // 유효성 검사
    public boolean isValid() {
        return answers != null
                && answers.size() == 10;
    }
}

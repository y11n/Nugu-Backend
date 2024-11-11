package team8.nugu.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TestRequestDto {
    private List<String> questions;
    private List<String> answers;

    // 유효성 검사
    public boolean isValid() {
        return questions != null
                && answers != null
                && questions.size() == 10
                && answers.size() == 10;
    }
}

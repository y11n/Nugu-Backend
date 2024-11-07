package team8.nugu.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TestResultResponseDto {
    private String nickname; // 응시자 닉네임
    private int correctAnswers; // 맞은 개수
    private int rank; // 등수
    private int totalParticipants; // 총 응시자 수
}

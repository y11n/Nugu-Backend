package team8.nugu.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import team8.nugu.common.converter.StringListConverter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class TestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", unique = true)
    private Users user; // 추후에 지윤 언니의 User 클래스 import할 것

    // JPA 엔티티에서 String[] 배열 타입은 직접 사용할 수 없음 -> converter 사용
    @Convert(converter = StringListConverter.class)
    @Column(name = "answer", columnDefinition = "TEXT") // 긴 문자열 저장을 위해 TEXT 타입 사용
    private List<String> answers = new ArrayList<>();
}

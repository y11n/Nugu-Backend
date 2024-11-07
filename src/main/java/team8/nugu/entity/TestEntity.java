package team8.nugu.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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
    private User user; // 추후에 지윤 언니의 User 클래스 import할 것

    // JPA 엔티티에서 String[] 배열 타입은 직접 사용할 수 없음
    @ElementCollection
    @CollectionTable(
            name = "test_result_answers",
            joinColumns = @JoinColumn(name = "test_result_id")
    )
    @Column(name = "answer")
    private List<String> answers = new ArrayList<>();
}

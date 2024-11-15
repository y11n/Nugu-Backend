package team8.nugu.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import team8.nugu.common.converter.StringListConverter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class TestResultEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "test_id")
    private TestEntity test;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users user;

    @Convert(converter = StringListConverter.class)
    @Column(name = "answer", columnDefinition = "TEXT")
    private List<String> answers = new ArrayList<>();

    @Column(name = "nickname")
    private String nickname;

    // 연관관계 편의 메서드 추가- user_id란이 null일 수 없음
    public void setUser(Users user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        this.user = user;
    }
}

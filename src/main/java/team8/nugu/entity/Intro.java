package team8.nugu.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Intro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn
    private Users user;

    private String content;

    private String keyword1;
    private String keyword2;
    private String keyword3;

}

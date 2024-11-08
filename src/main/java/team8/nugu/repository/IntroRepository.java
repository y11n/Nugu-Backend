package team8.nugu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import team8.nugu.entity.Intro;

public interface IntroRepository extends JpaRepository<Intro, Long> {
}

package team8.nugu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import team8.nugu.entity.Intro;
import team8.nugu.entity.Users;

import java.util.List;

public interface IntroRepository extends JpaRepository<Intro, Long> {
    List<Intro> findByUser(Users user);
}

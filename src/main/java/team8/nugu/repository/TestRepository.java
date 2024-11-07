package team8.nugu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import team8.nugu.entity.TestEntity;

public interface TestRepository extends JpaRepository<TestEntity, Long> {
}

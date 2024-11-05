package team8.nugu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team8.nugu.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    // oauth_id로 회원 조회
    Users findByOauth_id(String oauth_id);
}

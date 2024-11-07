package team8.nugu.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import team8.nugu.dto.UserDTO;
import team8.nugu.entity.Users;
import team8.nugu.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public boolean create(UserDTO dto){

        Users user = new Users();
        user.setUsername(dto.getUsername());

        // 동일한 usernmae 존재
        Boolean isExist = userRepository.existsByUsername(dto.getUsername());
        if(isExist){
            return false;
        }

        // 비밀번호 암호화 하여 저장
        user.setPassword(passwordEncoder.encode(dto.getPassword()));

        user.setNickname(dto.getNickname());
        user.setMbti(dto.getMbti());
        user.setOrg(dto.getOrg());
        user.setInsta_url(dto.getInsta_url());
        user.setIntro(dto.getIntro());
        user.setKeyword1(dto.getKeyword1());
        user.setKeyword2(dto.getKeyword2());
        user.setKeyword3(dto.getKeyword3());

        // DB에 저장
        userRepository.save(user);
        return true;
    }

}

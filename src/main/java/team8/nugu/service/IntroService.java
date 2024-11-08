package team8.nugu.service;

import org.springframework.stereotype.Service;
import team8.nugu.dto.IntroDTO;
import team8.nugu.entity.Intro;
import team8.nugu.entity.Users;
import team8.nugu.repository.IntroRepository;
import team8.nugu.repository.UserRepository;

@Service
public class IntroService {

    private final UserRepository userRepository;
    private final IntroRepository introRepository;

    public IntroService(UserRepository userRepository, IntroRepository introRepository) {
        this.userRepository = userRepository;
        this.introRepository = introRepository;
    }

    public void createByUser(String username, IntroDTO introDto) {
        // 유저 조회
        Users user = userRepository.findByUsername(username);

        Intro intro = new Intro();
        intro.setUser(user);
        intro.setContent(introDto.getContent());
        intro.setKeyword1(introDto.getKeyword1());
        intro.setKeyword2(introDto.getKeyword2());
        intro.setKeyword3(introDto.getKeyword3());
        introRepository.save(intro);

    }
}

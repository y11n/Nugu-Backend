package team8.nugu.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import team8.nugu.dto.IntroDTO;
import team8.nugu.dto.IntroResDTO;
import team8.nugu.entity.Intro;
import team8.nugu.entity.Users;
import team8.nugu.repository.IntroRepository;
import team8.nugu.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class IntroService {

    private final UserRepository userRepository;
    private final IntroRepository introRepository;

    public IntroService(UserRepository userRepository, IntroRepository introRepository) {
        this.userRepository = userRepository;
        this.introRepository = introRepository;
    }

    @Transactional
    public void createByUser(String username, IntroDTO introDto) {
        // 유저 조회
        Users user = userRepository.findByUsername(username);

        Intro intro = new Intro();
        intro.setUser(user);
        intro.setContent(introDto.getContent());

        List<String> list = new ArrayList<>();
        list.add(introDto.getKeyword1());
        list.add(introDto.getKeyword2());
        list.add(introDto.getKeyword3());
        intro.setKeywords(list);
        introRepository.save(intro);

    }

    public IntroResDTO getByUser(String username) {
        // 유저 조회
        Users user = userRepository.findByUsername(username);

        // 누구 소개 받아오기
        IntroResDTO dto = findTopKeywordsAndIntros(user);
        return dto;
    }

    public IntroResDTO getByOutsider(String num){
        UUID uuid = UUID.fromString(num);

        Users user = userRepository.findByUuid(uuid);
        if(user == null){
            throw new NullPointerException("User not found for UUID: " + uuid);
        }

        // 누구 소개 받아오기
        IntroResDTO dto = findTopKeywordsAndIntros(user);
        return dto;
    }

    // 누구 소개 - 상위 키워드 3개와 소개 목록
    private IntroResDTO findTopKeywordsAndIntros(Users user) {

        // 유저의 모든 '누구 소개' 검색
        List<Intro> intros = introRepository.findByUser(user);

        // 모든 키워드를 리스트에 저장
        List<String> allKeywords = intros.stream()
                .flatMap(intro -> intro.getKeywords().stream())
                .collect(Collectors.toList());

        // 각 키워드의 횟수 카운트
        Map<String, Long> keywordCount = allKeywords.stream()
                .collect(Collectors.groupingBy(keyword -> keyword, Collectors.counting()));

        // 빈도순 정렬하고 상위 3개 키워드 선택
        List<String> topKeywords = keywordCount.entrySet().stream()
                .sorted((e1, e2) -> {
                    // 같은 빈도에 한해 가나다 순 정렬
                    int frequencyComparison = Long.compare(e2.getValue(), e1.getValue());
                    if (frequencyComparison != 0) {
                        return frequencyComparison;
                    }
                    return e1.getKey().compareTo(e2.getKey());
                })
                .limit(3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        IntroResDTO dto = new IntroResDTO();
        dto.setKeyword1(topKeywords.size() > 0 ? topKeywords.get(0) : null);
        dto.setKeyword2(topKeywords.size() > 1 ? topKeywords.get(1) : null);
        dto.setKeyword3(topKeywords.size() > 2 ? topKeywords.get(2) : null);

        // 누구 소개 목록
        List<String> intro_list = intros.stream().map(Intro::getContent)
                        .collect(Collectors.toList());
        dto.setIntro_list(intro_list);

        return dto;

    }
}

package team8.nugu.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import team8.nugu.dto.IntroDTO;
import team8.nugu.dto.IntroResDTO;
import team8.nugu.service.IntroService;

@RestController
@RequestMapping("/intro")
public class IntroController {

    private final IntroService introService;

    public IntroController(IntroService introService) {
        this.introService = introService;
    }

    // 사용자의 누구 화면 GET
    @GetMapping
    public ResponseEntity<IntroResDTO> getIntro(){
        // 로그인한 사용자 username 가져오기
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();

        IntroResDTO userIntro = introService.getByUser(username);
        return ResponseEntity.status(HttpStatus.OK).body(userIntro);
    }

    // 사용자의 누구 소개 작성
    @PostMapping
    public ResponseEntity<String> addIntro(@RequestBody IntroDTO introDto){
        // 로그인한 사용자 username 가져오기
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        introService.createByUser(username, introDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("The introduction has been created successfully");
    }

}

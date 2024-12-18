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

    // 사용자의 누구 소개 조회
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

    // 접속자의 누구 소개 조회
    @GetMapping("/{uuid}")
    public ResponseEntity<IntroResDTO> getIntro(@PathVariable String uuid){
        try{
            IntroResDTO userIntro = introService.getByOutsider(uuid);
            return ResponseEntity.status(HttpStatus.OK).body(userIntro);
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }

    // 접속자의 누구 소개 작성
    @PostMapping("/{uuid}")
    public ResponseEntity<String> addIntro(@PathVariable String uuid, @RequestBody IntroDTO introDto){
        try{
            introService.createByOutsider(uuid, introDto);
            return ResponseEntity.status(HttpStatus.CREATED).body("The introduction has been created successfully");
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }

}

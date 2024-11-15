package team8.nugu.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import team8.nugu.dto.TestResultRequestDto;
import team8.nugu.dto.TestResultResponseDto;
import team8.nugu.entity.Users;
import team8.nugu.service.TestResultService;

import java.util.List;

@RestController
@RequestMapping("/test-results")
@RequiredArgsConstructor
public class TestResultController {
    private final TestResultService testResultService;

    // UUID로 테스트 응시 및 결과 제출
    @PostMapping("/submit/{uuid}")
    public ResponseEntity<TestResultResponseDto> submitTestResult(
            @PathVariable String uuid,
            @RequestBody TestResultRequestDto request
    ) {
        try {
            TestResultResponseDto response = testResultService.submitTestResult(uuid, request);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // UUID로 특정 테스트의 순위표 조회
    @GetMapping("/{uuid}/rankings")
    public ResponseEntity<List<TestResultResponseDto>> getTestResults(
            @PathVariable String uuid
    ) {
        try {
            List<TestResultResponseDto> results = testResultService.getTestResultsByUuid(uuid);
            return ResponseEntity.ok(results);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // 토큰으로 사용자 본인 테스트 순위표 조회
    @GetMapping("/rankings")
    public ResponseEntity<List<TestResultResponseDto>> getTestResultsByToken(
            HttpServletRequest request
    ) {
        try {
            // Authorization 헤더에서 토큰 추출
            String token = request.getHeader("Authorization");
            if (token == null || token.isEmpty()) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
            // Bearer 제거
            String accessToken = token.substring(7);

            List<TestResultResponseDto> results = testResultService.getTestResultsByToken(accessToken);
            return ResponseEntity.ok(results);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
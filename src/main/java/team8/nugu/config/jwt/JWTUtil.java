package team8.nugu.config.filter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

@Component
public class JWTUtil {

    private SecretKey secretKey;

    public JWTUtil(@Value("${spring.jwt.secret}")String secret){
        // String 타입의 SecretKey를 암호화하여 객체 타입으로 저장
        this.secretKey = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8),
                Jwts.SIG.HS256.key().build().getAlgorithm());
    }

    // 검증을 진행할 3개의 메소드
    public String getUsername(String token) {
        return Jwts.parser().verify
    }


    // 토큰 생성 메서드
}

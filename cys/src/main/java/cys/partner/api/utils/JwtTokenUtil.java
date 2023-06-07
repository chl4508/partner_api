package cys.partner.api.utils;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtTokenUtil {
    @Value("${jwt.secretKey}")
    private String secret; // jwt 비밀키 추후 일별 파일관리

    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("profileid", "a9da7509-3649-4727-8353-c529cf94d96f");
        claims.put("userid", "9b70dab4-d2d9-4704-b9bc-aac41a31672f");
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 토큰 만료 시간 설정 (예: 24시간)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public String getUsernameFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }

    public String getProfileidFromToken(String token) {
        return (String) Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().get("profileid");
    }

    public String getUseridFromToken(String token) {
        return (String) Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().get("userid");
    }

    public String resolveToken(HttpServletRequest req) {
        return req.getHeader("X-AUTH-TOKEN");
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException exception) {
            System.out.println("Token Expired");    //만료
            return false;
        } catch (JwtException exception) {
            System.out.println("Token Modified");   //변조
            return false;
        } catch (NullPointerException exception) {  //null
            System.out.println("Token Null");
            return false;
        } catch (Exception e){
            System.out.println("Token Exception");  //그외
            return false;
        }
    }
}

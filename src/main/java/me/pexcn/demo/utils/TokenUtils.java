package me.pexcn.demo.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import me.pexcn.demo.config.Constants;
import me.pexcn.demo.entity.model.User;
import org.springframework.http.HttpHeaders;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Date;

/**
 * @author pexcn
 * @date 2018-09-18
 */
public class TokenUtils {
    private static final String SECRET_KEY = "this_is_secret_key";
    private static final String ISSUER = "pexcn";
    private static final long EXPIRE_OFFSET = 3600L;
    private static final SignatureAlgorithm ALGORITHM = SignatureAlgorithm.HS512;
    private static final Key SIGNING_KEY = new SecretKeySpec(SECRET_KEY.getBytes(), ALGORITHM.getJcaName());
    private static final String TOKEN_HEADER = HttpHeaders.AUTHORIZATION;
    private static final String TOKEN_PREFIX = "Bearer ";

    private TokenUtils() {
    }

    public static String createToken(User user) {
        long now = System.currentTimeMillis();
        Date createdTime = new Date(now);
        Date expiredTime = new Date(now + EXPIRE_OFFSET * 1000);

        return Jwts.builder()
                .claim(Constants.TOKEN_KEY_UID, user.getUid())
                .setIssuer(ISSUER)
                .setIssuedAt(createdTime)
                .setExpiration(expiredTime)
                .signWith(ALGORITHM, SIGNING_KEY)
                .compact();
    }

    public static Claims parseToken(String token) throws RuntimeException {
        return Jwts.parser().setSigningKey(SIGNING_KEY).parseClaimsJws(token).getBody();
    }

    public static boolean isValid(String token) {
        try {
            Jwts.parser().setSigningKey(SIGNING_KEY).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

package com.cleanarchitecture.security;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.util.Date;

public class TokenUtils {

    private final static String ACCESS_TOKEN_SECRET = "123456789asdfghjklñqwertyuiopzxcvbnm,.356456356356356356";
    private final static Long ACCESS_TOKEN_VALIDITY_SECONDS =50L;

    public static String createToken(String nombre, String email){

            long expirationTime = ACCESS_TOKEN_VALIDITY_SECONDS * 1_000;
            Date expirationDate = new Date(System.currentTimeMillis() + expirationTime);
           System.out.println(expirationDate);

            Map<String, Object> extra = new HashMap<>();
            extra.put("nombre", nombre);
            System.out.println(nombre);
            return Jwts.builder()
                    .setSubject(email)
                    .setExpiration(expirationDate)
                    .addClaims(extra)
                    .signWith(Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes()))
                    .compact();
    }

    public static UsernamePasswordAuthenticationToken getUthentication(String token){
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(ACCESS_TOKEN_SECRET.getBytes())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            String email = claims.getSubject();
            return new UsernamePasswordAuthenticationToken(email, null, Collections.emptyList());
        }
        catch (JwtException e){
            return null;
        }
    }

}

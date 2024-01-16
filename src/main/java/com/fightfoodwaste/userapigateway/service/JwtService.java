package com.fightfoodwaste.userapigateway.service;

import com.fightfoodwaste.userapigateway.env.EnvVariables;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.security.Key;

@Component
@RequiredArgsConstructor
public class JwtService {

    private final EnvVariables envVariables;


    public void validateToken(final String token) {
        Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token);
    }


    private Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(envVariables.getKey());
        return Keys.hmacShaKeyFor(keyBytes);
    }
}

package com.smartorders.auth_service.security;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

	private final String secretKey = "MySuperSecureJwtKey@2025__Dev__Token__Key!";



	private Key getSigningKey() {
	    return Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
	}

	public String generateToken(String username) {
	    return Jwts.builder()
	        .setSubject(username)
	        .setIssuedAt(new Date())
	        .setExpiration(Date.from(Instant.now().plus(1, ChronoUnit.HOURS)))
	        .signWith(getSigningKey(), SignatureAlgorithm.HS256)
	        .compact();
	}

    public Claims extractClaims(String token) {
        return Jwts.parserBuilder()
            .setSigningKey(Keys.hmacShaKeyFor(secretKey.getBytes()))
            .build()
            .parseClaimsJws(token)
            .getBody();
    }

    public boolean isTokenValid(String token) {
        try {
            extractClaims(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
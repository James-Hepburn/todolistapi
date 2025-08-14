package com.example.todolistapi.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtUtil {
    private static String SECRET_KEY = "mySuperSecretKey12345";

    public static String generateToken(String email) {
        return Jwts.builder ()
                .setSubject (email)
                .setIssuedAt (new Date ())
                .setExpiration (new Date (System.currentTimeMillis () + 86400000))
                .signWith (SignatureAlgorithm.HS256, SECRET_KEY)
                .compact ();
    }
}

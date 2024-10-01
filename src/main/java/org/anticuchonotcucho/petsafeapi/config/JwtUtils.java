package org.anticuchonotcucho.petsafeapi.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtils {
    private static final String SECRET_KEY = "a8d6499164ddef09bc9453b0fdd2f427b7d08030d3a0826bd30ad86c7061379f991ebef5b98cb1b64d18f63a5d70eff26ed2c354d8cf9506dd5096d5eb82ba05"; // Usa una clave secreta segura
    private static final long TOKEN_VALIDITY = 86400000; // 1 día en milisegundos

    // Generar token JWT
    public static String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + TOKEN_VALIDITY))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY) // Asegúrate de usar la clave secreta correctamente
                .compact();
    }

    // Validar token JWT
    public static boolean validateToken(String token, String username) {
        final String tokenUsername = extractUsername(token);
        return (tokenUsername.equals(username) && !isTokenExpired(token));
    }

    // Extraer nombre de usuario del token
    public static String extractUsername(String token) {
        return extractAllClaims(token).getSubject();
    }

    // Verificar si el token ha expirado
    private static boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private static Date extractExpiration(String token) {
        return extractAllClaims(token).getExpiration();
    }

    // Extraer todos los claims del token
    private static Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }
}

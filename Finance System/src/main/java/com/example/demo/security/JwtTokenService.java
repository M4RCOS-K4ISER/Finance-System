package com.example.demo.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.example.demo.models.UserDetailsImpl;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Service
public class JwtTokenService {
    private static final String SECRET_KEY="";
    private static final String ISSUER="pizzurg-api";
    public String generateToken(UserDetailsImpl user){
        try{
            Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
            return JWT.create()
                    .withIssuer(ISSUER)
                    .withIssuedAt(creationDate())//Define o emissor do token
                    .withExpiresAt(expirationDate())//Define a data de expiração do token
                    .withSubject(user.getUsername())//Define assunto do token
                    .sign(algorithm);//Assina o token
        }catch(JWTCreationException e){
            throw new JWTCreationException("Erro ao gerar token.", e);
        }
    }

    public String getSubject(String token){
        try{
            Algorithm algoritm=Algorithm.HMAC256(SECRET_KEY);
            return JWT.require(algoritm)
                    .withIssuer(ISSUER)//Define o emissor do token
                    .build()
                    .verify(token)//Verifica a validade do token
                    .getSubject();//Obtém o assunto(nome do usuário)
        }catch (JWTVerificationException exception){
            throw new JWTVerificationException("Token inválido ou expirado.",exception);
        }
    }

    private Instant expirationDate() {
        return ZonedDateTime.now(ZoneId.of("America/Recife")).toInstant();
    }

    private Instant creationDate() {
        return ZonedDateTime.now(ZoneId.of("America/Recife")).plusHours(4).toInstant();
    }
}

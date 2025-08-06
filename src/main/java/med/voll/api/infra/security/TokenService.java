package med.voll.api.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import med.voll.api.domain.usuarios.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.secret}")
    private String apiSecret;

    public String generarToken(Usuario usuario){
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            return JWT.create()
                    .withIssuer("voll med")
                    .withSubject(usuario.getLogin())
                    .withClaim("id", usuario.getId())
                    .withExpiresAt(generarFechaExpiracion())
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            throw new RuntimeException();
        }
    }

    // valida si el usuario inicio sesion o no
    public String getSubject(String token){
        DecodedJWT verifier = null;

        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret); // validando la firma del token
            verifier   = JWT.require(algorithm)
                    .withIssuer("voll med")
                    .build()
                    .verify(token);

        } catch (JWTVerificationException exception){
            throw new RuntimeException("Token inválido", exception);
        }

        if(verifier.getSubject() == null){
            throw new RuntimeException("Verifier Invalido");
        }

        return verifier.getSubject();

    }

    private Instant generarFechaExpiracion(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-05:00"));
    }
}

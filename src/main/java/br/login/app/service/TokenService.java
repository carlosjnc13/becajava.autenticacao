package br.login.app.service;

import java.util.Date;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.login.app.model.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {

	
	
//	String secret1 = "asfadadgadadg";
//	private static final byte[] secret = secret1.ge
	
	public String gerarToken(Authentication authentication) {
		Usuario logado = (Usuario) authentication.getPrincipal();
		
		String secret = "asfadadgadadg";
		
		Date hoje = new Date();
		Date dataExpiration = new Date(hoje.getTime() + 86400000);
		
		return Jwts.builder()
				.setIssuer("API LOGIN")
				.setSubject(logado.getId().toString())
				.setIssuedAt(hoje)
				.setExpiration(dataExpiration)
				.signWith(SignatureAlgorithm.HS256, secret)
				.compact();
				
				
				
	}

//	public boolean isTokenValido(String token) {
//		try {
//			Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
//			return true;
//		} catch (Exception e) {
//			return false;
//			
//		}
//		
//	}

}

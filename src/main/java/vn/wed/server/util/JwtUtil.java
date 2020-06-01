package vn.wed.server.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.validation.valueextraction.ExtractedValue;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtil {
	private static String SECRET_KEY = "secret";

	public static String genToken(Map<String, Object> claims, int expInMin) {
		long currentTime = System.currentTimeMillis();
		int expInMs = expInMin * 60 * 1000;

		return Jwts.builder().setClaims(claims).setIssuedAt(new Date(currentTime))
				.setExpiration(new Date(currentTime + expInMs)).signWith(SignatureAlgorithm.HS256, SECRET_KEY)
				.compact();
	}

	public static Map<String, Object> validate(String token) throws Exception {
		Claims claims;

		// get exp time
		Date date = extractExpiration(token);
		// if expired => throw ExpireException
		boolean isExpired = date.before(new Date());
		if (isExpired) {
			throw new Exception("token expired");
		}
		// get claims => return claims
		claims = extractAllClaims(token);
		return new HashMap<>(claims);
	}

	private static Date extractExpiration(String token) {
		return extractClaim(token, Claims::getExpiration);
	}

	public static <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);
	}

	private static Claims extractAllClaims(String token) {
		return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
	}
}

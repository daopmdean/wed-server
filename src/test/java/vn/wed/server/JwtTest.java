package vn.wed.server;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import io.jsonwebtoken.ExpiredJwtException;
import vn.wed.server.util.JwtUtil;

@SpringBootTest
public class JwtTest {


	@Test
	void canCreateToken() {
		Map<String, Object> claims = new HashMap<String, Object>();
		claims.put("key1", "value1");
		JwtUtil.genToken(claims, "daopm99@gmail.com", 60);

		assertTrue(true);
	}

	@Test
	void canValidateToken() throws Exception {
		Map<String, Object> expected = new HashMap<String, Object>();
		expected.put("address", "VietNam");
		expected.put("haha", "hoho");
		String token = JwtUtil.genToken(expected, "daopm@gmail.com", 60);

		Map<String, Object> actual = JwtUtil.validate(token);

		assertThat(expected.get("address")).isEqualTo(actual.get("address"));
		assertThat(expected.get("haha")).isEqualTo(actual.get("haha"));
	}

	@Test
	void canCheckUnvalidateToken() {
		Map<String, Object> claims = new HashMap<String, Object>();
		String token = JwtUtil.genToken(claims, "daopm@gmail.com", -60);

		Exception exception = assertThrows(ExpiredJwtException.class, () -> {
			JwtUtil.validate(token);
		});

		String expected = "JWT expired";
		String actual = exception.getMessage();

		assertThat(actual).contains(expected);
	}

}

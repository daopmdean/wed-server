package vn.wed.server;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import vn.wed.server.controller.AuthController;

@SpringBootTest
class ServerApplicationTests {

	@Autowired
	private AuthController controller;

	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

}

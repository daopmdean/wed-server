package vn.wed.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.wed.server.controller.util.Response;
import vn.wed.server.entity.User;
import vn.wed.server.service.AuthService;
import vn.wed.server.util.JwtUtil;

@RestController
@RequestMapping(value = {"/auth"})
public class AuthController {

	@Autowired
	private AuthService service;
	
	@PostMapping("/login")
//	@RequestMapping(value = {"/login"}, method = RequestMethod.POST)
	public Response login(@RequestBody User loginInfo) {
		try {
			User user = service.login(loginInfo.getEmail(), loginInfo.getPassword());
			String token = service.genToken(user.getEmail());

			Object response = new Object() {
				@SuppressWarnings("unused")
				public final String accessToken = token;
			};
			return Response.success(response);
		} catch (Exception e) {
			return Response.error(e);	
		}
	}

	@PostMapping("/validate")
	public Object validate(@RequestBody String token) throws Exception {
		return JwtUtil.validate(token);
	}

	@PostMapping("/register")
	public boolean register(@RequestBody User userInfo) {
		return service.register(userInfo);
	}
	
	
}

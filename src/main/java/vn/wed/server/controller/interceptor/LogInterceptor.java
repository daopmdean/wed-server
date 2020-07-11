package vn.wed.server.controller.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import vn.wed.server.util.JwtUtil;

public class LogInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String uri = request.getRequestURI();
		
		if (uri.equals("/login") || uri.equals("/register")) {
			return true;
		}
		
		if (!isAuthorized(request)) {
			request.setAttribute("isAuthorized", false);
			return true;
		}
		request.setAttribute("isAuthorized", true);
		
		return true;
	}
	
	boolean isAuthorized(HttpServletRequest request) {
		final String authorizationHeader = request.getHeader("Authorization");
		
		if (authorizationHeader == null ) {
			return false;
		}
		
		if (!authorizationHeader.startsWith("Bearer ")) {
			return false;
		}

		String jwt = authorizationHeader.substring(7);
		if (!JwtUtil.isTokenValid(jwt)) {
			return false;
		}
		
		return true;
	}
}

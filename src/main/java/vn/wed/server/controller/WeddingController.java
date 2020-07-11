package vn.wed.server.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import vn.wed.server.controller.util.Response;
import vn.wed.server.entity.Wedding;
import vn.wed.server.service.WeddingService;
import vn.wed.server.util.ErrorCode;

@RestController
public class WeddingController {
	
	@Autowired
	private WeddingService service;
	
	@GetMapping("/weddings")
	public Response getWeddings(HttpServletRequest request) {
		boolean isAuthorized = (boolean) request.getAttribute("isAuthorized");
		
		if (!isAuthorized) {
			return Response.error(ErrorCode.FORBIDDEN, "Unauthorized");
		}
		List<Wedding> data = this.service.getWeddings();
		
		return Response.success(data);
	}
	
	@PostMapping("/wedding")
	public boolean createWedding(@RequestBody Wedding body) {
		Wedding wedding = new Wedding(body.getBrideName(), body.getGroomName(), body.getUserEmail());
		
		return this.service.create(wedding);
	}
	

}
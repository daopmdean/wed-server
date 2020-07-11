package vn.wed.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.wed.server.controller.util.Response;
import vn.wed.server.entity.Invitation;
import vn.wed.server.service.InvitationService;

@RestController
@RequestMapping("/invitation")
public class InvitationController {
	
	@Autowired
	private InvitationService invitationService;
	
	@GetMapping("/id")
	public Response getInvitationId() {
		
		return Response.success("ds");
	}
	
	@GetMapping("/all")
	public Response getInvitations() {
		List<Invitation> invitaitons = invitationService.getInvitations();
		return Response.success(invitaitons);
	}
	
}

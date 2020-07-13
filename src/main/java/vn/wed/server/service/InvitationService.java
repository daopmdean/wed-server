package vn.wed.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.wed.server.entity.Invitation;

@Service
public class InvitationService {
	
	@Autowired
	private InvitationRepository invitationRepo;
	
	public Invitation getInvitation(int invitationId) {
		return invitationRepo.getInvitationById(invitationId);
	}
	
	public List<Invitation> getInvitations() {
		return invitationRepo.getAllInvitations();
	}
}

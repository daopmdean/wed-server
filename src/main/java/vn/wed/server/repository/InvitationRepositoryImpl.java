package vn.wed.server.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vn.wed.server.entity.Invitation;
import vn.wed.server.entity.User;
import vn.wed.server.entity.Wedding;
import vn.wed.server.service.AuthRepository;
import vn.wed.server.service.InvitationRepository;
import vn.wed.server.service.WeddingRepository;

@Component
public class InvitationRepositoryImpl implements InvitationRepository {

	@Autowired
	private WeddingRepository weddingRepo;
	
	@Autowired
	private AuthRepository authRepo;
	
	List<Invitation> invitations;
	
	public InvitationRepositoryImpl() {
		invitations = new ArrayList<Invitation>();
		
		feedData();
	}
	
	@Override
	public boolean createInvitation(Invitation invitation) {
		invitation.setId(generateId());
		
		Wedding wedding = weddingRepo.getWeddingById(invitation.getWeddingId());
		List<Invitation> invitationList = wedding.getInvitationList();
		invitationList.add(invitation);
		wedding.setInvitationList(invitationList);
		invitations.add(invitation);
		
		String userEmail = wedding.getUserEmail();
		User user = authRepo.getUserByEmail(userEmail);
		List<Wedding> weddings = user.getWeddings();
		user.setWeddings(weddings);
		
		return true;
	}

	@Override
	public Invitation getInvitationById(int invitationId) {
		for (Invitation invitation : invitations) {
			if (invitationId == invitation.getId()) {
				return invitation;
			}
		}
		
		return null;
	}

	@Override
	public List<Invitation> getInvitationsByWeddingId(int weddingId) {
		List<Invitation> result = null;
		
		for (Invitation invitation : invitations) {
			if (invitation.getWeddingId() == weddingId) {
				if (result == null) {
					result = new ArrayList<Invitation>();
				}
				result.add(invitation);
			}
		}
		
		return result;
	}

	@Override
	public boolean remove(int invitationId) {
		// TODO Auto-generated method stub
		return false;
	}

	private void feedData() {
		invitations.add(DataFeeding.anInvitation());
		invitations.add(DataFeeding.moseInvitation());
		invitations.add(DataFeeding.binhInvitation());
		invitations.add(DataFeeding.chinhInvitation());
	}
	
	private int generateId() {
		return invitations.size() + 1;
	}

	@Override
	public List<Invitation> getAllInvitations() {
		return invitations;
	}
}

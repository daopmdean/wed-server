package vn.wed.server.service;

import java.util.List;

import vn.wed.server.entity.Invitation;

public interface InvitationRepository {
	public boolean createInvitation(Invitation invitation);
	public Invitation getInvitationById(int invitationId);
	public List<Invitation> getInvitationsByWeddingId(int weddingId);
	public List<Invitation> getAllInvitations();
	public boolean remove(int invitationId);
}

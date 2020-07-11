package vn.wed.server.entity;

public class Invitation {
	private int id;
	private String name;
	private String relationship;
	private String content;
	private String invitationLink;
	private boolean hasMorePeople;
	private int weddingId;

	public Invitation() {
	}

	public Invitation(String name, String relationship, String content, 
			String invitationLink, boolean hasMorePeople, int weddingId) {
		this.name = name;
		this.relationship = relationship;
		this.content = content;
		this.invitationLink = invitationLink;
		this.hasMorePeople = hasMorePeople;
		this.weddingId = weddingId;
	}
	
	// use for feeding data
	public Invitation(int id, String name, String relationship, 
			String content, String invitationLink, boolean hasMorePeople, int weddingId) {
		this.id = id;
		this.name = name;
		this.relationship = relationship;
		this.content = content;
		this.invitationLink = invitationLink;
		this.hasMorePeople = hasMorePeople;
		this.weddingId = weddingId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getInvitationLink() {
		return invitationLink;
	}

	public void setInvitationLink(String invitationLink) {
		this.invitationLink = invitationLink;
	}

	public boolean isHasMorePeople() {
		return hasMorePeople;
	}

	public void setHasMorePeople(boolean hasMorePeople) {
		this.hasMorePeople = hasMorePeople;
	}

	public int getWeddingId() {
		return weddingId;
	}

	public void setWeddingId(int weddingId) {
		this.weddingId = weddingId;
	}

	
}

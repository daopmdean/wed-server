package vn.wed.server.entity;

import java.util.Date;
import java.util.List;

public class Wedding {
	
	private int id;
	private String brideName;
	private String groomName;
	private Date time;
	private String bankAccount;
	private String address;
	private String link;
	private String userEmail;
	private List<Photo> photos;
	private List<Invitation> invitationList;

	public Wedding(String brideName, String groomName, String userEmail) {
		this.brideName = brideName;
		this.groomName = groomName;
		this.userEmail = userEmail;
	}
	
	// use for feeding data
	public Wedding(int id, String brideName, String groomName, Date time, String bankAccount, String address,
			String link, String userEmail, List<Photo> photos, List<Invitation> invitationList) {
		this.id = id;
		this.brideName = brideName;
		this.groomName = groomName;
		this.time = time;
		this.bankAccount = bankAccount;
		this.address = address;
		this.link = link;
		this.userEmail = userEmail;
		this.photos = photos;
		this.invitationList = invitationList;
	}

	public Wedding() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrideName() {
		return brideName;
	}

	public void setBrideName(String brideName) {
		this.brideName = brideName;
	}

	public String getGroomName() {
		return groomName;
	}

	public void setGroomName(String groomName) {
		this.groomName = groomName;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public List<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}

	public List<Invitation> getInvitationList() {
		return invitationList;
	}

	public void setInvitationList(List<Invitation> invitationList) {
		this.invitationList = invitationList;
	}

}

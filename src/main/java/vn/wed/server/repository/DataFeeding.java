package vn.wed.server.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import vn.wed.server.entity.Invitation;
import vn.wed.server.entity.Photo;
import vn.wed.server.entity.Relative;
import vn.wed.server.entity.User;
import vn.wed.server.entity.Wedding;

public class DataFeeding {
	
	// photo
	public static Photo samplePhoto() {
		return new Photo(1, "Quang Minh - Hong Dao", "https://www.google.com", 2);
	}
	
	public static Photo alexPhoto() {
		return new Photo(2, "alex wedding", "https://www.google.com", 1);
	}
	
	public static Photo newPhoto() {
		return new Photo(3, "Hoai Linh - Chi Tai", "https://www.google.com", 3);
	}

	// invitation
	public static Invitation anInvitation() {
		return new Invitation(1, "Nguyen Van An", "brother", "welcome", "google.com", true, 1);
	}
	
	public static Invitation moseInvitation() {
		return new Invitation(2, "Mose Felo", "friend", "welcome", "google.com", false, 1);
	}
	
	public static Invitation binhInvitation() {
		return new Invitation(3, "Tran Thi Binh", "sister", "welcome", "google.com", true, 2);
	}
	
	public static Invitation chinhInvitation() {
		return new Invitation(4, "Truong Cu Chinh", "uncle", "welcome", "google.com", true, 3);
	}
	
	// relative
	public static Relative alexMother() {
		return new Relative(1, "Mquirs", "Alex mother", "bride", 1);
	}
	
	public static Relative alexFather() {
		return new Relative(2, "Buyt", "Alex father", "bride", 1);
	}
	
	public static Relative phopeMother() {
		return new Relative(3, "Mquirs", "Phope mother", "groom", 1);
	}
	
	public static Relative phopeFather() {
		return new Relative(4, "Buyt", "Phope father", "groom", 1);
	}
	
	
	// weeding
	public static Wedding alexWedding() {
		List<Photo> alexPhotos = new ArrayList<Photo>();
		alexPhotos.add(DataFeeding.alexPhoto());
		
		List<Invitation> alexInvitations = new ArrayList<Invitation>();
		alexInvitations.add(DataFeeding.anInvitation());
		alexInvitations.add(DataFeeding.moseInvitation());
		
		return new Wedding(1, "Alex", "Phope", new Date(), "123456123456", "Dong Phuong Group",
				"google.com", "alex@gmail.com", alexPhotos, alexInvitations);
	}
	
	public static Wedding daopmWedding() {
		List<Photo> photos = new ArrayList<Photo>();
		photos.add(DataFeeding.samplePhoto());
		
		List<Invitation> invitations = new ArrayList<Invitation>();
		invitations.add(DataFeeding.binhInvitation());
		
		return new Wedding(2, "Sophia", "Tom", new Date(), "456789456789", "Vincom Center",
				"google.com", "daopm@gmail.com", photos, invitations);
	}
	
	public static Wedding daopm2Wedding() {
		List<Photo> photos = new ArrayList<Photo>();
		photos.add(DataFeeding.newPhoto());
		
		List<Invitation> invitations = new ArrayList<Invitation>();
		invitations.add(DataFeeding.chinhInvitation());
		
		return new Wedding(3, "Helen", "Hulk", new Date(), "123789123789", "Alibaba Group",
				"google.com", "daopm@gmail.com", photos, invitations);
	}
	
	// user
	public static User daopm() {
		List<Wedding> daopmWeddingList = new ArrayList<>();
		daopmWeddingList.add(DataFeeding.daopmWedding());
		daopmWeddingList.add(DataFeeding.daopm2Wedding());
		
		return new User(
				1,
				"daopm@gmail.com",
				"passworde$$eB3b3c1", 
				"e$$eB3b3c1",
				"Dao",
				"Pham",
				"admin",
				"male",
				"0368888100",
				"85 HT22 Hiep Thanh Ward, Ho Chi Minh City, Viet Nam",
				daopmWeddingList
		);
	}
	
	public static User alex() {
		List<Wedding> alexWeddingList = new ArrayList<>();
		alexWeddingList.add(DataFeeding.alexWedding());
		
		return new User(
				2,
				"alex@gmail.com",
				"pass%Ebe$&D&1B",
				"%Ebe$&D&1B",
				"Alex",
				"Max",
				"customer",
				"male",
				"012345678",
				"Phu My Hung district 7",
				alexWeddingList
		);
	}
}

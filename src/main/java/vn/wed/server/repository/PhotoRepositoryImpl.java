package vn.wed.server.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vn.wed.server.entity.Photo;
import vn.wed.server.entity.Wedding;
import vn.wed.server.service.PhotoRepository;
import vn.wed.server.service.WeddingRepository;

@Component
public class PhotoRepositoryImpl implements PhotoRepository {

	@Autowired
	private WeddingRepository weddingRepo;
	
	private List<Photo> photos;
	
	public PhotoRepositoryImpl() {
		photos = new ArrayList<Photo>();
		feedData();
	}

	@Override
	public boolean createPhoto(Photo photo) {
		int weddingId = photo.getWeddingId();
		Wedding wedding = weddingRepo.getWeddingById(weddingId);
		
		if (wedding == null) {
			return false;
		}
		
		if (photo.getId() == 0) {
			photo.setId(generatePhotoId());
		}
		
		List<Photo> photos = wedding.getPhotos();
		photos.add(photo);
		
		wedding.setPhotos(photos);
		this.photos.add(photo);
		
		return true;
	}

	@Override
	public Photo getPhotoById(int id) {
		for (Photo photo : photos) {
			if (photo.getId() == id) {
				return photo;
			}
		}
		
		return null;
	}

	@Override
	public Photo getPhotoByTitle(String title) {
		for (Photo photo : photos) {
			if (photo.getTitle().equalsIgnoreCase(title)) {
				return photo;
			}
		}
		
		return null;
	}
	
	@Override
	public List<Photo> getPhotosByWeddingId(int weddingId) {
		Wedding wedding = weddingRepo.getWeddingById(weddingId);
		if (wedding == null) {
			return null;
		}
		
		return wedding.getPhotos();
	}

	@Override
	public List<Photo> getPhotos() {
		return photos;
	}

	@Override
	public void removePhoto(int id) {
		Photo photo = getPhotoById(id);
		int weddingId = photo.getWeddingId();
		Wedding wedding = weddingRepo.getWeddingById(weddingId);
		List<Photo> photos = wedding.getPhotos();
		
		photos.remove(photo); // remove from it's wedding
		this.photos.remove(photo); // remove from photo repository
	}

	private void feedData() {
		photos.add(DataFeeding.samplePhoto());
		photos.add(DataFeeding.newPhoto());
		photos.add(DataFeeding.alexPhoto());
	}

	private int generatePhotoId() {
		return photos.size() + 1;
	}
	
	
}

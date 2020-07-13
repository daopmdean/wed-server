package vn.wed.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.wed.server.entity.Photo;

@Service
public class PhotoService {
	
	@Autowired
	private PhotoRepository photoRepo;
	
	public boolean create(Photo photo) {
		List<Photo> photos = photoRepo.getPhotos();
		
		for (Photo each : photos) {
			if (each.getId() == photo.getId()) {
				return false;
			}
		}
		
		return photoRepo.createPhoto(photo);
	}
	
	public Photo getPhotoById(int id) {
		return photoRepo.getPhotoById(id);
	}
	
	public Photo getPhotoByTitle(String title) {
		return photoRepo.getPhotoByTitle(title);
	}
	
	public List<Photo> getPhotos() {
		return photoRepo.getPhotos();
	}
}

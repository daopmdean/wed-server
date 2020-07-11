package vn.wed.server.service;

import java.util.List;

import vn.wed.server.entity.Photo;

public interface PhotoRepository {
	public boolean createPhoto(Photo photo);
	public Photo getPhotoById(int id);
	public Photo getPhotoByTitle(String title);
	public List<Photo> getPhotosByWeddingId(int weddingId);
	public List<Photo> getPhotos();
	public void removePhoto(int id);
}

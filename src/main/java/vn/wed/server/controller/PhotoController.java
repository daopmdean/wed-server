package vn.wed.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.wed.server.controller.util.Response;
import vn.wed.server.entity.Photo;
import vn.wed.server.service.PhotoService;

@RestController
@RequestMapping(value = {"/photo"})
public class PhotoController {
	
	@Autowired
	private PhotoService photoService;
	
	@PostMapping("/create")
	public boolean createPhoto(@RequestBody Photo photo) {
		return photoService.create(photo);
	}
	
	@GetMapping("/{id}")
	public Response getPhotoById(@PathVariable int id) {
		return Response.success(photoService.getPhotoById(id));
	}
	
	@GetMapping("/all")
	public Response getPhotos() {
		return Response.success(photoService.getPhotos());
	}
}

package vn.wed.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	@GetMapping("/getall")
	public List<Photo> getPhotos() {
		return photoService.getPhotos();
	}
}

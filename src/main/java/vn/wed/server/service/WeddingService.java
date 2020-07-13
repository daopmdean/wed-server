package vn.wed.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.wed.server.entity.Wedding;

@Service
public class WeddingService {
	
	@Autowired
	private WeddingRepository weddingRepo;
	
	public boolean create(Wedding wedding) {
		return weddingRepo.createWedding(wedding);
	}
	
	public List<Wedding> getWeddingsByEmail(String email) {
		return weddingRepo.getWeddingsByEmail(email);
	}
	
	public List<Wedding> getWeddings() {
		return weddingRepo.getWeddings();
	}
}


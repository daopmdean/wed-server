package vn.wed.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.wed.server.entity.Relative;

@Service
public class RelativeService {
	
	@Autowired
	private RelativeRepository relativeRepository;
	
	public List<Relative> getRelatives() {
		return relativeRepository.getRelatives();
	}
	
}

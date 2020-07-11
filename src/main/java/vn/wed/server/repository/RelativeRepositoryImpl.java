package vn.wed.server.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import vn.wed.server.entity.Relative;
import vn.wed.server.service.RelativeRepository;

@Component
public class RelativeRepositoryImpl implements RelativeRepository {

	private List<Relative> ralatives;
	
	public RelativeRepositoryImpl() {
		ralatives = new ArrayList<Relative>();
		
		feedData();
	}
	
	@Override
	public boolean createRelative(Relative relative) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Relative> getRelativesInWedding(int weddingId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void feedData() {
		ralatives.add(DataFeeding.alexMother());
		ralatives.add(DataFeeding.alexFather());
		ralatives.add(DataFeeding.phopeFather());
		ralatives.add(DataFeeding.phopeMother());
	}
}

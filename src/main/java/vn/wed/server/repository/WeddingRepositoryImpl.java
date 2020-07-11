package vn.wed.server.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vn.wed.server.entity.User;
import vn.wed.server.entity.Wedding;
import vn.wed.server.service.AuthRepository;
import vn.wed.server.service.WeddingRepository;

@Component
public class WeddingRepositoryImpl implements WeddingRepository {

	private List<Wedding> weddings;

	@Autowired
	private AuthRepository authRepo;

	public WeddingRepositoryImpl() {
		weddings = new ArrayList<Wedding>();

		feedData();
	}

	@Override
	public boolean createWedding(Wedding wedding) {
		User user = authRepo.getUserByEmail(wedding.getUserEmail());

		if (user == null) {
			return false;
		}
		wedding.setId(generateWeddingId());
		user.getWeddings().add(wedding);
		weddings.add(wedding);
		
		return true;
	}

	@Override
	public List<Wedding> getWeddings() {
		return weddings;
	}

	@Override
	public Wedding getWeddingById(int id) {
		for (Wedding wedding : weddings) {
			if (wedding.getId() == id) {
				return wedding;
			}
		}

		return null;
	}

	@Override
	public List<Wedding> getWeddingsByEmail(String email) {
		List<Wedding> list = new ArrayList<Wedding>();
		for (Wedding wedding : weddings) {
			if (wedding.getUserEmail().equals(email)) {
				list.add(wedding);
			}
		}
		
		return list;
	}

	@Override
	public boolean remove(Wedding wedding) {
		return weddings.remove(wedding);
	}

	private int generateWeddingId() {
		return weddings.size() + 1;
	}
	
	private void feedData() {
		weddings.add(DataFeeding.alexWedding());
		weddings.add(DataFeeding.daopmWedding());
		weddings.add(DataFeeding.daopm2Wedding());
	}

}

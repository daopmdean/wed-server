package vn.wed.server.service;

import java.util.List;

import vn.wed.server.entity.Wedding;

public interface WeddingRepository {
	public boolean createWedding(Wedding wedding);
	public Wedding getWeddingById(int id);
	public List<Wedding> getWeddingsByEmail(String email);
	public List<Wedding> getWeddings();
	public boolean remove(Wedding wedding);
}
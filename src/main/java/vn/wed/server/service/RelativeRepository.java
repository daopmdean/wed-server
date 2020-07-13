package vn.wed.server.service;

import java.util.List;

import vn.wed.server.entity.Relative;

public interface RelativeRepository {
	public boolean createRelative(Relative relative);
	public List<Relative> getRelativesInWedding(int weddingId);
	public List<Relative> getRelatives();
	
}

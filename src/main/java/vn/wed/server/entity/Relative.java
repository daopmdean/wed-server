package vn.wed.server.entity;

public class Relative {
	private int id;
	private String name;
	private String relationship;
	private String side;
	private int weddingId;

	public Relative() {
		
	}
	
	// use for feeding data
	public Relative(int id, String name, String relationship, String side, int weddingId) {
		this.id = id;
		this.name = name;
		this.relationship = relationship;
		this.side = side;
		this.weddingId = weddingId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public String getSide() {
		return side;
	}

	public void setSide(String side) {
		this.side = side;
	}

	public int getWeddingId() {
		return weddingId;
	}

	public void setWeddingId(int weddingId) {
		this.weddingId = weddingId;
	}

}

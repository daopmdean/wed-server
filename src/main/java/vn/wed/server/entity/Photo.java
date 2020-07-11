package vn.wed.server.entity;

public class Photo {
	private int id;
	private String title;
	private String imageUrl;
	private int weddingId;

	public Photo() {
	}

	public Photo(String title, String imageUrl, int weddingId) {
		this.title = title;
		this.imageUrl = imageUrl;
		this.weddingId = weddingId;
	}

	// use for feeding data
	public Photo(int id, String title, String imageUrl, int weddingId) {
		this.id = id;
		this.title = title;
		this.imageUrl = imageUrl;
		this.weddingId = weddingId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public int getWeddingId() {
		return weddingId;
	}

	public void setWeddingId(int weddingId) {
		this.weddingId = weddingId;
	}

}

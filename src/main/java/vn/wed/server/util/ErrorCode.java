package vn.wed.server.util;

public enum ErrorCode {
	BAD_REQUEST(400, "Bad request"),
	FORBIDDEN(403, "Forbidden"),
	INTERNAL_SERVER_ERROR(500, "Internal Server Error");
	
	private final int value;
	private final String reasonPhrase;
	
	ErrorCode(int value, String reasonPhrase) {
		this.value = value;
		this.reasonPhrase = reasonPhrase;
	}
	
	@Override
	public String toString() {
		return this.value + " " + name();
	}

	public int getValue() {
		return value;
	}

	public String getReasonPhrase() {
		return reasonPhrase;
	}
}

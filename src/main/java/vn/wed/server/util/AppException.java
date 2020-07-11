package vn.wed.server.util;

public class AppException extends Exception {
	private static final long serialVersionUID = 1L;

	private ErrorCode code;
	private Object data;
	
	public AppException(ErrorCode code, String message, Object data) {
		super(message);
		this.code = code;
	}
	
	public AppException(ErrorCode code, String message) {
		this(code, message, null);
	}

	public ErrorCode getCode() {
		return code;
	}

	public void setCode(ErrorCode code) {
		this.code = code;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

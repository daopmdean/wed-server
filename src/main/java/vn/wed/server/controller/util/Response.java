package vn.wed.server.controller.util;

import vn.wed.server.util.AppException;
import vn.wed.server.util.ErrorCode;

public class Response {
	private Object data;
	private ResponseError error;

	private Response() {
	}

	public static Response success(Object data) {
		Response response = new Response();
		response.setData(data);
		return response;
	}

	public static Response error(ErrorCode code, String message, Object data) {
		Response response = new Response();
		ResponseError error = new ResponseError(code.getValue(), message, data);
		response.setError(error);
		return response;
	}

	public static Response error(ErrorCode code, String message) {
		return Response.error(code, message, null);
	}

	public static Response error(String message) {
		return Response.error(ErrorCode.INTERNAL_SERVER_ERROR, message);
	}

	public static Response error(Exception e) {
		if (e instanceof AppException) {
			AppException ae = (AppException) e;
			return Response.error(ae.getCode(), ae.getMessage(), ae.getData());
		}
		return Response.error(e.getMessage());
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public ResponseError getError() {
		return error;
	}

	public void setError(ResponseError error) {
		this.error = error;
	}

}

class ResponseError {
	private int code;
	private String message;
	private Object data;

	ResponseError(int code, String message, Object data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}

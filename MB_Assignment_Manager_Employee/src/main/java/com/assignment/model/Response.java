package com.assignment.model;

public class Response {

	private String code;
	private Boolean status;
	private String message;
	private Object payload;

	public Response() {
		super();
	}

	public Response(String code, Boolean status, String message, Object payload) {
		super();
		this.code = code;
		this.status = status;
		this.message = message;
		this.payload = payload;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getPayload() {
		return payload;
	}

	public void setPayload(Object payload) {
		this.payload = payload;
	}

	@Override
	public String toString() {
		return "Response [code=" + code + ", status=" + status + ", message=" + message + ", payload=" + payload + "]";
	}

}

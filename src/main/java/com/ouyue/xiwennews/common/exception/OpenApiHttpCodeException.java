package com.ouyue.xiwennews.common.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;

import java.nio.charset.Charset;

public class OpenApiHttpCodeException extends HttpStatusCodeException {

	private static final long serialVersionUID = 6537986964300694538L;

	private String responseBody = null;

	public OpenApiHttpCodeException(HttpStatus statusCode) {
		super(statusCode);
	}

	public OpenApiHttpCodeException(HttpStatus statusCode, String statusText) {
		super(statusCode, statusText);
	}

	public OpenApiHttpCodeException(HttpStatus statusCode, String statusText, byte[] responseBody,
                                    Charset responseCharset) {
		super(statusCode, statusText, responseBody, responseCharset);
	}

	public OpenApiHttpCodeException(HttpStatus statusCode, String statusText, HttpHeaders responseHeaders,
                                    byte[] responseBody, Charset responseCharset) {
		super(statusCode, statusText, responseHeaders, responseBody, responseCharset);
	}

	public OpenApiHttpCodeException(HttpStatus statusCode, String statusText, String responseBody) {
		super(statusCode, statusText);
		this.responseBody = responseBody;
	}

	public String getResponseBody() {
		return responseBody;
	}

	public void setResponseBody(String responseBody) {
		this.responseBody = responseBody;
	}

	@Override
	public String toString() {
		return String.format("response:%1$s,statusCode:%2$s", responseBody, getStatusCode());
	}

}

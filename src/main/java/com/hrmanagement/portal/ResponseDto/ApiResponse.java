package com.hrmanagement.portal.ResponseDto;
import java.util.Map;

public class ApiResponse<T> {
    private T data;
    private Map<String, Object> meta;
    private ApiErrorResponse error;

    public ApiResponse() {
    }

    public ApiResponse(T data, Map<String, Object> meta) {
        this.data = data;
        this.meta = meta;
    }

    public ApiResponse(ApiErrorResponse error) {
        this.error = error;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Map<String, Object> getMeta() {
        return meta;
    }

    public void setMeta(Map<String, Object> meta) {
        this.meta = meta;
    }

	public ApiErrorResponse getError() {
		return error;
	}

	public void setError(ApiErrorResponse error) {
		this.error = error;
	}
}

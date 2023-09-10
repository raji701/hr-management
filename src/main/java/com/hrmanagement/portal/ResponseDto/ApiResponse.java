package com.hrmanagement.portal.ResponseDto;
import java.util.Map;

public class ApiResponse<T> {
    private T data;
    private Map<String, Object> meta;
   

    public ApiResponse() {
    }

    public ApiResponse(T data, Map<String, Object> meta) {
        this.data = data;
        this.meta = meta;
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

	
}

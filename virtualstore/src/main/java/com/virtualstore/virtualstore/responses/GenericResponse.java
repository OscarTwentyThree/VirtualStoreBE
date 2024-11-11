package com.virtualstore.virtualstore.responses;

public class GenericResponse {

    private String token;

    private long expiresIn;

    private String msg;

    private Boolean error;

    private Object data;

    public String getToken() {
        return token;
    }

    public GenericResponse setToken(String token) {
        this.token = token;
        return this;
    }

    public long getExpiresIn() {
        return expiresIn;
    }

    public GenericResponse setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
        return this;
    }

    public Boolean getError() {
        return error;
    }

    public GenericResponse setError(Boolean error) {
        this.error = error;
        return this;
    }

    public Object getData() {
        return data;
    }

    public GenericResponse setData(Object data) {
        this.data = data;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public GenericResponse setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    @Override
    public String toString() {
        return "GanericResponse{" +
                "token='" + token + '\'' +
                ", expiresIn=" + expiresIn +
                ", msg='" + msg + '\'' +
                ", error=" + error +
                ", data=" + data +
                '}';
    }
    
}

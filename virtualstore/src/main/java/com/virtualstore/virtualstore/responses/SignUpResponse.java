package com.virtualstore.virtualstore.responses;

import com.virtualstore.virtualstore.dtos.UserBasicInfo;

public class SignUpResponse {

    private String token;

    private long expiresIn;

    private String msg;

    private Boolean error;

    private UserBasicInfo data;

    public String getToken() {
        return token;
    }

    public SignUpResponse setToken(String token) {
        this.token = token;
        return this;
    }

    public long getExpiresIn() {
        return expiresIn;
    }

    public SignUpResponse setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
        return this;
    }

    public Boolean getError() {
        return error;
    }

    public SignUpResponse setError(Boolean error) {
        this.error = error;
        return this;
    }

    public UserBasicInfo getData() {
        return data;
    }

    public SignUpResponse setData(UserBasicInfo data) {
        this.data = data;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public SignUpResponse setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    @Override
    public String toString() {
        return "SignUpResponse{" +
                "token='" + token + '\'' +
                ", expiresIn=" + expiresIn +
                ", msg='" + msg + '\'' +
                ", error=" + error +
                ", data=" + data +
                '}';
    }
    
}

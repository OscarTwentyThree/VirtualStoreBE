package com.virtualstore.virtualstore.responses;

import com.virtualstore.virtualstore.dtos.UserBasicInfo;

public class LoginResponse {
    private String token;

    private long expiresIn;

    private String msg;

    private Boolean error;

    private UserBasicInfo data;

    public String getToken() {
        return token;
    }

    public LoginResponse setToken(String token) {
        this.token = token;
        return this;
    }

    public long getExpiresIn() {
        return expiresIn;
    }

    public LoginResponse setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
        return this;
    }
    public Boolean getError() {
        return error;
    }

    public LoginResponse setError(Boolean error) {
        this.error = error;
        return this;
    }

    public UserBasicInfo getData() {
        return data;
    }

    public LoginResponse setData(UserBasicInfo data) {
        this.data = data;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public LoginResponse setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "token='" + token + '\'' +
                ", expiresIn=" + expiresIn +
                ", error=" + error +
                '}';
    }
}
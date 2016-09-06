package com.jason.retrofitdemo.model;

/**
 * @version v1.0.0
 * @authon zjh
 * @date 2016-06-28
 * @desc
 */
public class User {
    private long uid;
    private String userName;
    private String token;

    public long getUid() {return uid;}

    public void setUid(long uid) {this.uid = uid;}

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", userName='" + userName + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}

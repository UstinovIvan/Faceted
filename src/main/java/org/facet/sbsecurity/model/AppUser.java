package org.facet.sbsecurity.model;

import org.apache.log4j.Logger;

import java.util.Map;

public class AppUser {
    static Logger logger = Logger.getLogger(AppUser.class);
    private Long userId;
    private String userName;
    private String encrytedPassword;
    private Map<String, Object> userInfo;

    public AppUser() {

    }

    public AppUser(Long userId, String userName, String encrytedPassword) {
        this.userId = userId;
        this.userName = userName;
        this.encrytedPassword = encrytedPassword;
        logger.info(String.format("User %s has join", userName));
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEncrytedPassword() {
        return encrytedPassword;
    }

    public void setEncrytedPassword(String encrytedPassword) {
        this.encrytedPassword = encrytedPassword;
    }

    @Override
    public String toString() {
        return this.userName + "/" + this.encrytedPassword;
    }

    public Map<String, Object> getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(Map<String, Object> userInfo) {
        this.userInfo = userInfo;
    }

    protected void finalize() throws Throwable
    {
        LoginedUsers.removeUserFromLogined(this.getUserName());
        System.out.println("destroyed");
    }
}
package org.facet.sbsecurity.model;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LoginedUsers {
    static Logger logger = Logger.getLogger(LoginedUsers.class);
    private static List<AppUser> users = new ArrayList<>();

    public LoginedUsers() {

    }

    public static void addUser(AppUser appUser) {
        users.add(appUser);
        System.out.println("Добавлен " + appUser.getUserName());

    }

    public static Map<String, Object> getUserInfo(String userName) {
        for (AppUser s : users) {
            if (s.getUserName().equals(userName)) {
                return s.getUserInfo();
            }
        }
        return null;
    }

    public static void removeUserFromLogined(String userName) {
        users.remove(userName);

        logger.info(String.format("Deleting user from list: ", userName));
    }
}

package org.facet;

import java.io.BufferedWriter;
import org.facet.sbsecurity.utils.EncrytedPasswordUtils;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.io.FileWriter;
import java.security.Principal;
import java.util.Map;


public class CreateQuery {
    public static void main(String[] args)  {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/ivanustinov/Desktop/insertAppUser.txt"));
            BufferedWriter writer2 = new BufferedWriter(new FileWriter("/Users/ivanustinov/Desktop/logpass.txt"));
            BufferedWriter writer3 = new BufferedWriter(new FileWriter("/Users/ivanustinov/Desktop/insertUserRole.txt"));
            String strLine;

            writer.write("insert into App_User (USER_ID, USER_NAME, ENCRYTED_PASSWORD, ENABLED) \n values ");
            writer3.write("insert into user_role (ID, USER_ID, ROLE_ID) \n values ");
            writer2.write("login        pass \n");
            for (int i = 3; i < 11; i++) {
                String login = Integer.toString(116450 + i);
                writer.write("(" + i + ", \'" + login + "\', \'" + EncrytedPasswordUtils.encrytePassword(login) + "\', 1), \n");
                writer2.write(login + "         " + login + "\n");
                writer3.write("(" + (i + 1) + ", " + i + ", 2), \n");
            }
            writer.write(";");
            writer3.write(";");
            writer.close();
            writer2.close();
            writer3.close();
        }
        catch (Exception e) {
            e.getStackTrace();
        }

    }

}

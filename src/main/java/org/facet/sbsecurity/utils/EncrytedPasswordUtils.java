package org.facet.sbsecurity.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//import java.io.*;

public class EncrytedPasswordUtils {

    // Encryte Password with BCryptPasswordEncoder
    public static String encrytePassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }

    public static void main(String[] args) {
        String password = "123";
        String encrytedPassword = encrytePassword(password);

        System.out.println("Encryted Password: " + encrytedPassword);
    }

    /*public static void main(String[] args)  {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/ivanustinov/Desktop/zapros1.txt"));
            BufferedWriter writer2 = new BufferedWriter(new FileWriter("/Users/ivanustinov/Desktop/logpass.txt"));
            BufferedWriter writer3 = new BufferedWriter(new FileWriter("/Users/ivanustinov/Desktop/zapros2.txt"));
            String strLine;

            writer.write("insert into App_User (USER_ID, USER_NAME, ENCRYTED_PASSWORD, ENABLED) \n values ");
            writer3.write("insert into user_role (ID, USER_ID, ROLE_ID) \n values ");
            writer2.write("login        pass \n");
            for (int i = 3; i < 11; i++) {
                String login = Integer.toString(116450 + i);
                writer.write("(" + i + ", \'" + login + "\', \'" + encrytePassword(login) + "\', 1), \n");
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

    }*/

}
package org.facet.working.controller;

import org.facet.working.DBConnect;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ControllerLK {
    @RequestMapping(value = "/lk", method = RequestMethod.GET)
    public String lCabinetMain(Model model, Principal principal) throws SQLException {

        String sql = "select * from students where ticket=" + principal.getName() + ";";
        DBConnect dBconnect = new DBConnect();

        Statement statement = dBconnect.DBConnect().createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        Map<String, String> studentInfo = new HashMap<>();

        if (resultSet.next()) {
            studentInfo.put("ticket", resultSet.getString("ticket"));
            studentInfo.put("surname", resultSet.getString("surname"));
            studentInfo.put("patronymic", resultSet.getString("patronymic"));
            studentInfo.put("ticket", resultSet.getString("ticket"));
            studentInfo.put("birth", resultSet.getString("birth_date"));
            studentInfo.put("sgroup", resultSet.getString("sgroup"));
            studentInfo.put("budget", resultSet.getString("ticket"));
            studentInfo.put("level", resultSet.getString("level"));
            studentInfo.put("budget", resultSet.getString("ticket"));
            studentInfo.put("telephone", resultSet.getString("telephone"));
            studentInfo.put("hostel", resultSet.getString("hostel"));
            studentInfo.put("email", resultSet.getString("email"));
        }
        model.addAllAttributes(studentInfo);
        return "lk";
    }
}

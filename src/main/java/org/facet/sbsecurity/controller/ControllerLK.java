package org.facet.sbsecurity.controller;

import org.facet.sbsecurity.dao.AppUserDAO;
import org.facet.sbsecurity.model.AppUser;
import org.facet.sbsecurity.service.UserDetailsServiceImpl;
import org.facet.sbsecurity.utils.EncrytedPasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.security.Principal;
import java.util.List;
import java.util.Map;

@Controller
public class ControllerLK extends JdbcDaoSupport{
    private static Map<String, Object> studentInfo = null;

    @Autowired
    public ControllerLK (DataSource dataSource) {
        super();
        setDataSource(dataSource);
    }
    public ControllerLK () {

    }
    @RequestMapping(value = "/lk", method = RequestMethod.GET)
    public String lCabinetMain(Model model, Principal principal) throws SQLException {

        String sql = "select * from students where ticket=" + principal.getName() + ";";

        if (studentInfo == null) {
            System.out.println("create");

            studentInfo = this.getJdbcTemplate().queryForMap(sql);

            if (!this.getConnection().isClosed()) {
                this.getConnection().close();
                System.out.println("Connection was closed");
            }
        }

        model.addAllAttributes(studentInfo);
        return "lk";
    }
    
    public void setNullstudentInfo() {
        studentInfo = null;
        System.out.println("Obnul");
    }



    @RequestMapping(value = "/lk/changePass", method = RequestMethod.GET)
    public String changeP(Model model) {

        return "changePass";
    }

    @RequestMapping(value = "/lk/changePass", method = RequestMethod.POST)
    public String changePass(@RequestParam String newPass,
                      @RequestParam String confirmNewPass,
                                           Model model,
                                           Principal principal) {

        String sql = "update stankin_db.APP_USER set ENCRYTED_PASSWORD = \'"
                + EncrytedPasswordUtils.encrytePassword(newPass)
                + "\' where USER_NAME = \'" + principal.getName() + "\';";
        boolean passNew = newPass.equals(confirmNewPass); //Соответствие нового

        if (passNew) {
                try {
                    this.getJdbcTemplate().execute(sql);
                    this.getJdbcTemplate().execute("commit;");
                }
                catch (Exception e) {
                    model.addAttribute("message", "Произошла ошибка");
                    return "changePass";
                }
                model.addAttribute("message", "Пароль успешно изменен");
        }
        else {
            model.addAttribute("message", "Пароли не совпадают");
        }
        return "changePass";
    }
}
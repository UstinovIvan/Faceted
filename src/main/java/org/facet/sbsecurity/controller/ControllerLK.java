package org.facet.sbsecurity.controller;

import org.facet.sbsecurity.dao.AppUserDAO;
import org.facet.sbsecurity.dao.RequestsDAO;
import org.facet.sbsecurity.dao.ScheduleDAO;
import org.facet.sbsecurity.model.LoginedUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.security.Principal;
import java.util.List;
import java.util.Map;

@Controller
public class ControllerLK {

    //Создание переменной класса, который берет в базе данные о заявках
    //TODO: придумать, как избавиться от объявления в этом месте
    @Autowired
    private RequestsDAO requestsDAO;

    @Autowired
    private AppUserDAO appUserDAO;

    @Autowired
    private ScheduleDAO scheduleDAO;

    @RequestMapping(value = "/lk", method = RequestMethod.GET)
    public String lCabinetMain(Model model, Principal principal) {

        //Получаем текущего пользователя
        User loginedUser = (User) ((Authentication) principal).getPrincipal();

        model.addAllAttributes(LoginedUsers.getUserInfo(loginedUser.getUsername()));
        return "lk";
    }

    @RequestMapping(value = "/lk/changepass", method = RequestMethod.GET)
    public String changePassGet(Model model) {

        return "changepass";
    }

    @RequestMapping(value = "/lk/changepass", method = RequestMethod.POST)
    public String changePassPost(@RequestParam String newPass1,
                      @RequestParam String newPass2,
                                           Model model,
                                           Principal principal) {


        boolean passNew = newPass1.equals(newPass2); //Соответствие нового
        if (passNew) {

            String message = this.appUserDAO.changePass(principal.getName(), newPass1);
            model.addAttribute("message", message);
            System.out.println(message);
        }
        else {
            model.addAttribute("message", "Новые пароли не совпадают");
        }


        return "changepass";
    }

    @RequestMapping(value = "/lk/orders", method = RequestMethod.GET)
    public String ordersPage(Model model) {

        return "orders";
    }


    @RequestMapping(value = "/lk/orders", method = RequestMethod.POST)
    public String ordersSubmit(@RequestParam String order,  Model model, Principal principal) {


        //Успешно ли создалась заявка
        boolean success = this.requestsDAO.createNewRequest(principal.getName(), order, 1);

        if (success) {
            model.addAttribute("message", "Заявка успешно создана");
        }
        else {
            model.addAttribute("message", "Ошибка при создании заявки");
        }
        return "orders";
    }

    @RequestMapping(value = "/lk/schedule", method = RequestMethod.GET)
    public String schedulePage(Model model, Principal principal) {

        List<Map<String, Object>> schedule = this.scheduleDAO.getSchedule(principal.getName());
        model.addAttribute("schedule", schedule);
        return "schedule";
    }

    @RequestMapping(value = "/lk/myOrders", method = RequestMethod.GET)
    public String myOrders(Model model, Principal principal) {

        //Получает в список все заявки по данному принципалу
        List<Map<String, Object>> requests = this.requestsDAO.getMyRequests(principal.getName());
        model.addAttribute("requests", requests);
        return "myOrders";
    }

    @RequestMapping(value = "/teachers", method = RequestMethod.GET)
    public String teachersSchedule(Model model) {
        List<Map<String, Object>> teachersList = this.scheduleDAO.getTeachersList();
        model.addAttribute("teachersList", teachersList);

        for (Map<String, Object> s : teachersList) {
            for (Map.Entry<String, Object> map : s.entrySet()) {
                if (map.getKey().equals("TEACHER_ID")) {
                    List<Map<String, Object>> scheduleTeacher = this.scheduleDAO
                            .getTeacherSchedule(map.getValue().toString());
                    model.addAttribute("teacher" + map.getValue().toString(), scheduleTeacher);
                }
            }
        }

        return "teachers";
    }

/*    @RequestMapping(value = { "/teachers", "/teachers/" }, method = RequestMethod.POST)
    public String teachersSchedule(@RequestParam Map<String, String> allRequestParam, Model model) {

        for (Map.Entry s : allRequestParam.entrySet()) {
            System.out.println(s.getKey() + "   " + s.getValue());
        }
        //List<Map<String, Object>> teacherSchedule = this.scheduleDAO.getTeacherSchedule();
        return "teachers";
    }*/
}
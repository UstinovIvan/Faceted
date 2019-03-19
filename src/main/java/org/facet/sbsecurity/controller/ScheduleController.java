package org.facet.sbsecurity.controller;

import org.facet.sbsecurity.dao.ScheduleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.List;
import java.util.Map;

@Controller
public class ScheduleController {

    @Autowired
    private ScheduleDAO scheduleDAO;

    @RequestMapping(value = "/lk/schedule", method = RequestMethod.GET)
    public String schedulePage(Model model, Principal principal) {

        List<Map<String, Object>> schedule = this.scheduleDAO.getSchedule(principal.getName());
        model.addAttribute("schedule", schedule);
        return "schedule";
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

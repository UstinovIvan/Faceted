package org.facet.sbsecurity.controller;

import org.facet.sbsecurity.dao.RequestsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;
import java.util.Map;

@Controller
public class OrdersController {

    @Autowired
    private RequestsDAO requestsDAO;

    @RequestMapping(value = "/lk/orders", method = RequestMethod.GET)
    public String ordersPage(Model model) {

        return "orders";
    }


    @RequestMapping(value = "/lk/orders", method = RequestMethod.POST)
    public String ordersSubmit(@RequestParam String order, Model model, Principal principal) {


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

    @RequestMapping(value = "/lk/myOrders", method = RequestMethod.GET)
    public String myOrders(Model model, Principal principal) {

        //Получает в список все заявки по данному принципалу
        List<Map<String, Object>> requests = this.requestsDAO.getMyRequests(principal.getName());
        model.addAttribute("requests", requests);
        return "myOrders";
    }

}

package org.facet.sbsecurity.service;

import org.facet.sbsecurity.dao.AppUserDAO;
import org.facet.sbsecurity.dao.RequestsDAO;
import org.facet.sbsecurity.dao.ScheduleDAO;
import org.springframework.beans.factory.annotation.Autowired;

public class Autowireds {
    @Autowired
    private RequestsDAO requestsDAO;

    @Autowired
    private AppUserDAO appUserDAO;

    @Autowired
    private ScheduleDAO scheduleDAO;

    public RequestsDAO getRequestsDAO() {
        return requestsDAO;
    }

    public AppUserDAO getAppUserDAO() {
        return appUserDAO;
    }

    public ScheduleDAO getScheduleDAO() {
        return scheduleDAO;
    }
}

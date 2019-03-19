package org.facet.sbsecurity.utils;

import java.util.Calendar;
import java.util.Date;

public class DayOfWeek {
    public static int getDayOfWeek() {
        Calendar c = Calendar.getInstance();
        Date date = new Date();
        c.setTime(date);
        return c.get(Calendar.DAY_OF_WEEK);

    }
}

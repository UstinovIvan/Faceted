package org.facet.sbsecurity.dao;

import org.apache.log4j.Logger;
import org.facet.sbsecurity.utils.DayOfWeek;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
@Transactional
public class ScheduleDAO extends JdbcDaoSupport {
    static Logger logger = Logger.getLogger(ScheduleDAO.class);

    @Autowired
    public ScheduleDAO (DataSource dataSource) {
        this.setDataSource(dataSource);
    }

    public ScheduleDAO() {

    }

    public List<Map<String, Object>> getSchedule(String ticket) {
        int day = DayOfWeek.getDayOfWeek() - 1;
        String sql = "select t2.subject_name as Subject, t1.time_id as Time, " +
                "t3.teacher_name as Teacher, t1.classroom as Classroom " +
                "from stankin_db.schedule as t1, stankin_db.subjects as t2, " +
                "stankin_db.TEACHERS as t3 where t1.subject_id = t2.subject_id and " +
                "t1.teacher_id = t3.teacher_id and t1.day_id = " + day + " and t1.group_id in " +
                "(select group_id from stankin_db.students where ticket = " + ticket + ") order by time_id asc;";

        try {
            return this.getJdbcTemplate().queryForList(sql);
            //statement.execute("commit");
        }
        catch (NullPointerException e) {
            logger.error(String.format("Error in get schedule \"%s\"", ticket), e);
            return null;
        }
        catch (Exception e) {
            logger.error(String.format("Other error in get schedule. Ticket: %s", ticket), e);
            return null;
        }
    }
}

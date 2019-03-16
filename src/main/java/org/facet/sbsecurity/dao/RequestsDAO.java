package org.facet.sbsecurity.dao;

import org.apache.log4j.Logger;
import org.facet.sbsecurity.model.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Repository
@Transactional
public class RequestsDAO extends JdbcDaoSupport {
    static Logger logger = Logger.getLogger(RequestsDAO.class);

    private String sql;
    private static final String REQUEST_INSERT = "insert into stankin_db.requests " +
            "(ticket_from, request_type, application_date, request_status) values (";
    //private static final String REQUEST_SELECT;
    @Autowired
    public RequestsDAO(DataSource dataSource) {
        this.setDataSource(dataSource);

    }

    //Создает новую заявку и запрос на insert для нее
    public boolean createNewRequest(String ticket, String type, int status) {

        Request request = new Request(ticket, type, status);
        sql = REQUEST_INSERT + request.sqlInsert() + ");";

        return sendRequestIntoDB(sql);

    }

    //Отправка заявки в базу через выполнение sql запроса
    public boolean sendRequestIntoDB(String sql) {
        try {
            this.getJdbcTemplate().execute(sql);
            logger.info("Added request");
            this.getJdbcTemplate().execute("commit;");
            return true;
        }
        catch (NullPointerException e) {
            logger.error(String.format("Error in sending query \"%s\"", sql), e);
            return false;
        }
        catch (Exception e) {
            logger.error(String.format("Request sending error. Sql: %s", sql), e);
            return false;
        }
    }

    public RequestsDAO() {

    }

    //Запрос в базу на получение списка заявок по полученному номеру студенческого
    public List<Map<String, Object>> getMyRequests(String ticket) {
        String sql = "select t1.description as Request, t3.application_date as Date, t2.description as Status " +
                "from stankin_db.TYPES_REQUESTS as t1, stankin_db.STATUS_REQUESTS as t2, " +
                "stankin_db.REQUESTS as t3 where t1.id = t3.request_type and t2.id = t3.request_status " +
                "and t3.ticket_from = " + ticket + " order by application_date desc;";

        try {
            return this.getJdbcTemplate().queryForList(sql);
            //statement.execute("commit");
        }
        catch (NullPointerException e) {
            logger.error(String.format("Error in get list of requests \"%s\"", sql), e);
            return null;
        }
        catch (Exception e) {
            logger.error(String.format("Other error in getter requests. Sql: %s", sql), e);
            return null;
        }

    }
}

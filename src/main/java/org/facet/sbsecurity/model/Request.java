package org.facet.sbsecurity.model;

public class Request {
    private String TICKET_FROM;
    private String REQUEST_TYPE;
    private static String APP_DATE = "sysdate()";
    private int REQUEST_STATUS;

    private static final String REQUEST_INSERT = "insert into stankin_db.requests " +
            "(ticket_from, request_type, application_date, request_status) values (";


    public Request(String ticket, String type, int status) {
        this.TICKET_FROM = ticket;
        this.REQUEST_TYPE = type;
        this.REQUEST_STATUS = status;
    }

    //Добавляет в список параметров запроса необходимые поля
    public String sqlInsert() {
        String sql = this.TICKET_FROM + ", " + this.REQUEST_TYPE + ", " + APP_DATE + ", " + this.REQUEST_STATUS;
        return sql;
    }
}

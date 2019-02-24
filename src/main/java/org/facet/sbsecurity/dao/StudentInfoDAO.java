package org.facet.sbsecurity.dao;

import org.apache.log4j.Logger;
import org.facet.sbsecurity.mapper.AppUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.Map;

@Repository
@Transactional
public class StudentInfoDAO extends JdbcDaoSupport {
    static Logger logger = Logger.getLogger(StudentInfoDAO.class);
    @Autowired
    public StudentInfoDAO(DataSource dataSource) {
        this.setDataSource(dataSource);
    }

    public Map<String, Object> findStudentInfo(String userName) {
        // Select .. from App_User u Where u.User_Name = ?
        String sql = "select * from students where ticket= " + userName;

        Object[] params = new Object[] { userName };
        AppUserMapper mapper = new AppUserMapper();
        try {
            Map<String, Object> studentInfo = this.getJdbcTemplate().queryForMap(sql);
            logger.info(String.format("Request information on student with ticket #%s", userName));
            return studentInfo;
        } catch (EmptyResultDataAccessException e) {
            logger.error(String.format("Error requesting information on student with ticket # %s", userName), e);
            return null;
        }
    }
}

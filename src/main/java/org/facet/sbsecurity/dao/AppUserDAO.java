package org.facet.sbsecurity.dao;

import javax.sql.DataSource;

import org.facet.sbsecurity.mapper.AppUserMapper;
import org.facet.sbsecurity.model.AppUser;
import org.facet.sbsecurity.utils.EncrytedPasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class AppUserDAO extends JdbcDaoSupport {

    @Autowired
    public AppUserDAO(DataSource dataSource) {
        this.setDataSource(dataSource);
    }

    public AppUser findUserAccount(String userName) {
        // Select .. from App_User u Where u.User_Name = ?
        String sql = AppUserMapper.BASE_SQL + " where u.User_Name = ? ";
        Object[] params = new Object[] { userName };
        AppUserMapper mapper = new AppUserMapper();
        try {
            AppUser userInfo = this.getJdbcTemplate().queryForObject(sql, params, mapper);
            return userInfo;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public String changePass(String userName, String newPass) {

        String sql = "update stankin_db.APP_USER set ENCRYTED_PASSWORD = \'"
                + EncrytedPasswordUtils.encrytePassword(newPass)
                + "\' where USER_NAME = \'" + userName + "\';";

        try {
            this.getJdbcTemplate().execute(sql);
            this.getJdbcTemplate().execute("commit;");
            return "Пароль успешно изменен";
        }
        catch (Exception e) {
            logger.error("Change password error", e);
            return "Ошибка смены пароля";
        }

    }

}
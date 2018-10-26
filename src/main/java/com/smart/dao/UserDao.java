package com.smart.dao;

import com.smart.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Jason on 2018/4/4.
 *
 * @author jason
 */


@Repository
public class UserDao {
    private JdbcTemplate jdbcTemplate;
    private static final String MATCH_COUNT_SQL = " SELECT * FROM  " + "t_user WHERE user_name=?";
    private static final String UPDATE_LOGIN_INFO_SQL = " UPDATE t_user SET " +
            " last_visit=?,last_ip=?,credits=? WHERE user_id=?";

    public User findUserByUserName(final String userName) {
        final User user = new User();
        jdbcTemplate.query(MATCH_COUNT_SQL, new Object[]{userName},
                new RowCallbackHandler() {
                    @Override
                    public void processRow(ResultSet rs) throws SQLException {
                        user.setUserID(rs.getInt("user_id"));
                        user.setUserName(userName);
                        user.setCredits(rs.getInt("credits"));
                    }
                }
        );
        return user;


    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * @param userName
     * @param password
     * @return
     * @Repository定义一个Dao bean，使用即那个AutoWired讲spring容器中的bean注入进来。
     */
    public int getMatchCount(String userName, String password) {
        String sqlStr = " SELECT count(*) FROM t_user " +
                " WHERE user_name =? and password =? ";
        return jdbcTemplate.queryForObject(sqlStr, new Object[]{userName, password}, Integer.class);
    }

    public void updateLoginInfo(User user) {
        jdbcTemplate.update(UPDATE_LOGIN_INFO_SQL, new Object[]{user.getLastVisit(), user.getLastIP(), user.getCredits(), user.getUserID()});
    }


}

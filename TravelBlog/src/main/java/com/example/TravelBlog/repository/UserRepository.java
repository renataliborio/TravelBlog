package com.example.TravelBlog.repository;

        import com.example.TravelBlog.model.User;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.jdbc.core.JdbcTemplate;
        import org.springframework.jdbc.core.RowCallbackHandler;
        import org.springframework.stereotype.Repository;
        import org.springframework.jdbc.core.RowMapper;
        import java.sql.ResultSet;
        import java.sql.SQLException;
        import java.util.List;
@Repository
public class UserRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<User> findAllUsers() {
        return jdbcTemplate.query("select * User", new UserRowMapper());
    }

    public void saveNewUser(User user_id) {
        String mySql = "insert into user(user_id, user_name) values (?,?)";
        int num = jdbcTemplate.update(mySql, user_id.getUser_id(),
                user_id.getUser_profile());
        System.out.println(num);
    }

    private class UserRowMapper implements RowMapper<User> {
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setUser_id(rs.getInt("user_id"));
            user.setFirstName(rs.getString("firstName"));
            user.setLastName(rs.getString("lastName"));
            user.setEmail(rs.getString("email"));

            return user;
        }

    }
}
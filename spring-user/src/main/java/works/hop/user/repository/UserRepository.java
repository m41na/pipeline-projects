package works.hop.user.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.lang.NonNullApi;
import org.springframework.stereotype.Repository;
import works.hop.user.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final JdbcTemplate jdbcTemplate;

    public List<User> allUsers() {
        return jdbcTemplate.query("select * from tbl_users", (rs, rowNum) -> new User(
                UUID.fromString(rs.getString("id")),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("email_address")
        ));
    }

    public User byId(UUID id) {
        return jdbcTemplate.query("select * from tbl_users where id = ?::uuid",
                ps -> ps.setObject(1, id),
                rs -> {
                    if (rs.next()) {
                        return new User(
                                UUID.fromString(rs.getString("id")),
                                rs.getString("first_name"),
                                rs.getString("last_name"),
                                rs.getString("email_address")
                        );
                    }
                    return null;
                });
    }
}

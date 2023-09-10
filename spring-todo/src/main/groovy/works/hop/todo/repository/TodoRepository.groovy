package works.hop.todo.repository

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.DataAccessException
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.PreparedStatementSetter
import org.springframework.jdbc.core.ResultSetExtractor
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Repository
import works.hop.todo.model.Todo

import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException

@Repository
class TodoRepository {

    @Autowired
    JdbcTemplate jdbcTemplate

    List<Todo> allTodos(){
        jdbcTemplate.query("select * from tbl_todos", new RowMapper<Todo>() {
            @Override
            Todo mapRow(ResultSet rs, int rowNum) throws SQLException {
                new Todo(id: UUID.fromString(rs.getString("id")),
                        task: rs.getString("task"),
                        completed: rs.getString("completed"))
            }
        })
    }

    Todo byId(UUID id) {
        jdbcTemplate.query("select * from tbl_todos where id = ?::uuid", new PreparedStatementSetter(){

            @Override
            void setValues(PreparedStatement ps) throws SQLException {
                ps.setObject(1, id)
            }
        }, new ResultSetExtractor<Todo>() {

            @Override
            Todo extractData(ResultSet rs) throws SQLException, DataAccessException {
                if(rs.next()){
                    return new Todo(id: UUID.fromString(rs.getString("id")),
                            task: rs.getString("task"),
                            completed: rs.getString("completed"))
                }
                return null
            }
        })
    }
}

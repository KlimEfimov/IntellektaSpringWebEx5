package com.ex5.intellektaspringwebex5.repositories;

import com.ex5.intellektaspringwebex5.models.Message;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Objects;

@Repository
public class MessageRepository {

    private final JdbcTemplate jdbcTemplate;

    public MessageRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Message> messageRowMapper = (r, i) -> {
        Message rowObject = new Message();
        rowObject.setId(r.getInt(1));
        rowObject.setText(r.getString(2));
        rowObject.setTag(r.getString(3));
        return rowObject;
    };

    public List<Message> findMessagesByUsername(String username) {
        String sqlQuery = "SELECT * FROM messages WHERE tag='" + username + "'";
        return jdbcTemplate.query(sqlQuery, messageRowMapper);
    }

    public void insertNewMessage(String text, String tag) {
        String sqlQuery = "INSERT INTO messages (text, tag) VALUES (?, ?)";
        try(PreparedStatement statement = Objects.requireNonNull(jdbcTemplate.getDataSource()).getConnection().prepareStatement(sqlQuery)) {
            statement.setString(1, text);
            statement.setString(2, tag);
            jdbcTemplate.update(con -> statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Message> findAllMessages() {
        String sqlQuery = "SELECT * FROM messages";
        return jdbcTemplate.query(sqlQuery, messageRowMapper);
    }
}

package ru.otus.hw5.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.otus.hw5.dao.AuthorRepo;
import ru.otus.hw5.model.Author;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Repository
public class AuthorRepositoryJdbc implements AuthorRepo {

    private final NamedParameterJdbcTemplate jdbc;

    @Autowired
    public AuthorRepositoryJdbc(NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    final String insert = "insert into author (authorid, authorname) values (:authorid, :authorname)";
    final String update = "update author set authorname = :authorname where authorid = :authorid";
    final String delete = "delete from author where authorid = :authorid";

    private static class AuthorMapper implements RowMapper<Author> {

        @Override
        public Author mapRow(ResultSet resultSet, int i) throws SQLException {
            int id = resultSet.getInt("authorid");
            String name = resultSet.getString("authorname");
            return new Author(id, name);
        }
    }

    public Author findAuthorById(int authorid) {
        final HashMap<String, Object> params = new HashMap<>(1);
        params.put("authorid", authorid);
        return jdbc.queryForObject("select * from author where authorid = :authorid", params,
                new AuthorMapper());
    }

    public void insertAuthor(Author author) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("authorid", author.getAuthorid());
        params.put("authorname", author.getAuthorname());
        jdbc.update(insert, params);
    }

    public void updateAuthor(int id, String newName) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("authorid", id);
        params.put("authorname", newName);
        jdbc.update(update, params);
    }

    public void deleteAuthor(int id) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("authorid", id);
        jdbc.update(delete, params);
    }

    public List<Author> getAllAuthors() {
        return jdbc.query("select * from author", new AuthorMapper());
    }

}

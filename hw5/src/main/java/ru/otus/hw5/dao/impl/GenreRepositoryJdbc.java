package ru.otus.hw5.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.otus.hw5.dao.GenreRepo;
import ru.otus.hw5.model.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

@Repository
public class GenreRepositoryJdbc implements GenreRepo {
    private final NamedParameterJdbcTemplate jdbc;

    @Autowired
    public GenreRepositoryJdbc(NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    final String insert = "insert into genre (genreid, genrename) values (:genreid, :genrename)";
    final String update = "update genre set genrename = :genrename where genreid = :genreid";
    final String delete = "delete from genre where genreid = :genreid";

    private static class GenreMapper implements RowMapper<Genre> {

        @Override
        public Genre mapRow(ResultSet resultSet, int i) throws SQLException {
            int genreId = resultSet.getInt("genreid");
            String genreName = resultSet.getString("genrename");
            return new Genre(genreId, genreName);
        }
    }

    public void insert(Genre genre) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("genreid", genre.getGenreId());
        params.put("genrename", genre.getGenreName());
        jdbc.update(insert, params);
    }

    public void updateGenreName(int id, String newName) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("genreid", id);
        params.put("genrename", newName);
        jdbc.update(update, params);
    }

    public void deleteGenre(int id) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("genreid", id);
        jdbc.update(delete, params);
    }

    public Genre findGenreById(int id) {
        final HashMap<String, Object> params = new HashMap<>(1);
        params.put("genreid", id);
        return jdbc.queryForObject("select * from genre where genreid = :genreid", params,
                new GenreMapper());
    }

    public List<Genre> getAllGenres() {
        return jdbc.query("select * from genre", new GenreMapper());

    }

}

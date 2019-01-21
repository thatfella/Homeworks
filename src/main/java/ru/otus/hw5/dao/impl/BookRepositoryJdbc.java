package ru.otus.hw5.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.otus.hw5.dao.BookRepo;
import ru.otus.hw5.model.Author;
import ru.otus.hw5.model.Book;
import ru.otus.hw5.model.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

@Repository
public class BookRepositoryJdbc implements BookRepo {
    private final NamedParameterJdbcTemplate jdbc;

    final String insert = "insert into book (id, name, authorid, genreid) values (:id, :name, :authorid, :genreid)";
    final String update = "update book set name = :name where id = :id";
    final String delete = "delete from book where id = :id";

    @Autowired
    public BookRepositoryJdbc(NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    private static class BookMapper implements RowMapper<Book> {

        @Override
        public Book mapRow(ResultSet resultSet, int i) throws SQLException {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int authorId = resultSet.getInt("authorid");
            String authorName = resultSet.getString("authorname");
            int genreId = resultSet.getInt("genreid");
            String genreName = resultSet.getString("genrename");
            return new Book(id, name, new Author(authorId, authorName), new Genre(genreId, genreName));
        }
    }

    public Book findBookById(int bookid) {
        final HashMap<String, Object> params = new HashMap<>(1);
        params.put("id", bookid);
        return jdbc.queryForObject(getBookWithAllInfo() + " where b.id = :id", params,
                new BookMapper());
    }

    public String getBookWithAllInfo() {
        return "select b.id, b.name, a.authorid, a.authorname, g.genreid, g.genrename from Book b inner join Author a on b.authorid=a.authorid inner join Genre g on b.genreid = g.genreid";

    }

    public void insertBook(Book book) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("id", book.getId());
        params.put("name", book.getName());
        params.put("authorid", book.getAuthor().getAuthorid());
        params.put("genreid", book.getGenre().getGenreId());
        jdbc.update(insert, params);
    }

    public void updateBook(int id, String newName) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("id", id);
        params.put("name", newName);
        jdbc.update(update, params);
    }

    public void deleteBook(int id) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("id", id);
        jdbc.update(delete, params);
    }

    public List<Book> getAllBooksByAuthorId(int authorId) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("authorid", authorId);
        return jdbc.query(getBookWithAllInfo() + " where a.authorid = :authorid", params, new BookMapper());
    }

    public List<Book> getAllBooks() {
        return jdbc.query(getBookWithAllInfo(), new BookMapper());
    }

}

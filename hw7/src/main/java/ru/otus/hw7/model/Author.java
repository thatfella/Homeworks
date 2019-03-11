package ru.otus.hw7.model;

import javax.persistence.*;

@Entity
@Table(name = "Author")
public class Author {

    public Author() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "authorid")
    private int authorid;
    @Column(name = "authorname")
    private String authorname;


    public Author(int authorid, String authorname) {
        this.authorid = authorid;
        this.authorname = authorname;
    }

    public Author(int authorid) {
        this.authorid = authorid;
    }

    public int getAuthorid() {
        return authorid;
    }

    public void setAuthorid(int authorid) {
        this.authorid = authorid;
    }

    public String getAuthorname() {
        return authorname;
    }

    public void setAuthorname(String authorname) {
        this.authorname = authorname;
    }

    @Override
    public String toString() {
        return "Author:" + this.getAuthorname();
    }
}

package ru.otus.hw5.model;

public class Author {

    private int authorid;
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

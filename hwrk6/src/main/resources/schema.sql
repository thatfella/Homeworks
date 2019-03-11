

DROP TABLE IF EXISTS Book;
DROP TABLE IF EXISTS Author;
DROP TABLE IF EXISTS Genre;
DROP TABLE IF EXISTS Comments;
CREATE TABLE Author(authorid INT PRIMARY KEY, authorname VARCHAR(255));


CREATE TABLE Genre(genreid INT PRIMARY KEY, genrename VARCHAR(255));
CREATE TABLE Book(id INT PRIMARY KEY, name VARCHAR(255), authorid INT, genreid INT,
                   FOREIGN KEY (authorid) REFERENCES Author(authorid)
                  , FOREIGN KEY (genreid) REFERENCES Genre(genreid));

CREATE TABLE Comments (commentid INT PRIMARY KEY, text VARCHAR(255), bookId INT, FOREIGN KEY (bookId) references Book(id));

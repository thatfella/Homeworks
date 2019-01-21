

DROP TABLE IF EXISTS Book;
DROP TABLE IF EXISTS Author;
DROP TABLE IF EXISTS Genre;
CREATE TABLE Author(authorid INT PRIMARY KEY, authorname VARCHAR(255));
CREATE TABLE Genre(genreid INT PRIMARY KEY, genrename VARCHAR(255));
CREATE TABLE Book(id INT PRIMARY KEY, name VARCHAR(255), authorid INT, genreid INT,
                   FOREIGN KEY (authorid) REFERENCES Author(authorid) ON DELETE CASCADE,
                   FOREIGN KEY (genreid) REFERENCES Genre(genreid) ON DELETE CASCADE
);



insert into Author
values(1,'Remarque');
insert into Author
values(2,'Walls');

insert into Genre
values (1, 'Novel');
insert into Genre
values (99, 'Computer Science');

insert into Book
values(1,'The Road Back',1, 1);



DROP TABLE IF EXISTS Book;
DROP TABLE IF EXISTS Author;
DROP TABLE IF EXISTS Genre;
CREATE TABLE Author(authorid INT PRIMARY KEY, authorname VARCHAR(255));
--
-- insert into Author
-- values(1,'Remarque');
-- insert into Author
-- values(2,'Walls');

CREATE TABLE Genre(genreid INT PRIMARY KEY, genrename VARCHAR(255));
CREATE TABLE Book(id INT PRIMARY KEY, userName VARCHAR(255), authorid INT, genreid INT,
                   FOREIGN KEY (authorid) REFERENCES Author(authorid)
                  , FOREIGN KEY (genreid) REFERENCES Genre(genreid));


insert into Author  values  (1, 'Remarque'),( 2, 'Eckel');

insert into Genre
values (1, 'Novel');


insert into Book
values(1,'The Road Back',1, 1);

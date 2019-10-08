# fiction

DB commands:

```
USE fiction;

CREATE TABLE authors
(
    author_id int(10) PRIMARY KEY AUTO_INCREMENT,
    fullname VARCHAR(100) NOT NULL,
    birthday int(4),
    biography VARCHAR(100)
)
COLLATE='utf8_general_ci';

INSERT INTO `authors` (`fullname`,`birthday`,`biography`)
VALUES
    ("Пушкин", 1780, "Что то о Пушкине"),
    ("Лермонтов", 1782, "Что то о Лермонтове"),
    ("Кинг", 1930, "Что то о Кинге");
```

```
USE fiction;

CREATE TABLE books
(
    book_id int(10) PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    year int(4)
)
COLLATE='utf8_general_ci';

INSERT INTO `books` (`name`,`year`)
VALUES
    ("Мцыри", 1830),
    ("Руно", 1835),
    ("Оно", 1975);
```

```
USE fiction;

CREATE TABLE genres
(
    genre_id int(10) PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100)
)
COLLATE='utf8_general_ci';

INSERT INTO `genres` (`name`)
VALUES
    ("Повесть"),
    ("Рассказ"),
    ("Ужасы");
```
```
USE fiction;

CREATE TABLE books_genres
(
    id int(10) PRIMARY KEY AUTO_INCREMENT,
    book_id int(10),
    genre_id int(10)
)
COLLATE='utf8_general_ci';

INSERT INTO `books_genres` (`book_id`, `genre_id`)
VALUES
    (1, 1),
    (2, 2),
    (3, 3);
```
```
USE fiction;

CREATE TABLE books_authors
(
    id int(10) PRIMARY KEY AUTO_INCREMENT,
    book_id int(10),
    author_id int(10)
)
COLLATE='utf8_general_ci';

INSERT INTO `books_authors` (`book_id`, `author_id`)
VALUES
    (1, 1),
    (2, 2),
    (3, 3);
```

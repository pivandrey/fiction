# fiction

DB commands:

```
CREATE TABLE authors
(
    author_id SERIAL PRIMARY KEY,
    fullname VARCHAR(100) NOT NULL,
    birthday integer,
    biography VARCHAR(100)
)

INSERT INTO authors (fullname, birthday, biography)
VALUES
    ('Пушкин', 1780, 'Что то о Пушкине'),
    ('Лермонтов', 1782, 'Что то о Лермонтове'),
    ('Кинг', 1930, 'Что то о Кинге');
```

```
CREATE TABLE books
(
    book_id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    year integer
)

INSERT INTO books (name, year)
VALUES
    ('Мцыри', 1830),
    ('Руно', 1835),
    ('Оно', 1975);
```

```
CREATE TABLE genres
(
    genre_id SERIAL PRIMARY KEY,
    name VARCHAR(100)
)

INSERT INTO genres (name)
VALUES
    ('Повесть'),
    ('Рассказ'),
    ('Ужасы');
```

```
CREATE TABLE books_genres
(
    id SERIAL PRIMARY KEY,
    book_id integer,
    genre_id integer
)

INSERT INTO books_genres (book_id, genre_id)
VALUES
    (1, 1),
    (2, 2),
    (3, 3);
```

```
CREATE TABLE books_authors
(
    id SERIAL PRIMARY KEY,
    book_id integer,
    author_id integer
)

INSERT INTO books_authors (book_id, author_id)
VALUES
    (1, 1),
    (2, 2),
    (3, 3);
```

package library.fiction.model;

import javax.persistence.*;

@Entity
@Table(name = "books_genres")
public class BookGenre {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "book_id")
    private int book_id;

    @Column(name = "genre_id")
    private int genre_id;

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(int genre_id) {
        this.genre_id = genre_id;
    }
}

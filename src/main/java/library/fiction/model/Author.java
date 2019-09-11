package library.fiction.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "authors")
public class Author {

    @Id
    @Column(name = "author_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "birthday")
    private int birthday;

    @Column(name = "biography")
    private String biography;

    @ManyToMany(mappedBy = "authors")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Book> books = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getBirthday() {
        return birthday;
    }

    public void setBirthday(int birthday) {
        this.birthday = birthday;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return getId() + ' ' + getFullname() + ' ' + getBirthday() + ' ' + getBiography();
    }
}

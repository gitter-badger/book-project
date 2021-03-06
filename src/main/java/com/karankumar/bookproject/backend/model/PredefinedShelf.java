package com.karankumar.bookproject.backend.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
public class PredefinedShelf extends BaseEntity {
    public enum ShelfName {
        TO_READ("To read"),
        READING("Reading"),
        READ("Read"),
        DID_NOT_FINISH("Did not finish");

        private final String name;

        ShelfName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    @NotNull
    @Enumerated(value = EnumType.STRING)
    public ShelfName shelfName;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "shelf")
    private Set<Book> books;

    protected PredefinedShelf() {
    }

    public PredefinedShelf(ShelfName shelfName) {
        this.shelfName = shelfName;
    }

    public ShelfName getShelfName() {
        return shelfName;
    }

    public void setShelfName(ShelfName shelfName) {
        this.shelfName = shelfName;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "PredefinedShelf{" +
                "shelfName=" + shelfName +
                ", books=" + books +
                '}';
    }
}

package pl.coderslab.controllers;

import pl.coderslab.domain.Book;
import pl.coderslab.service.BookService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MemoryBookService implements BookService {

    private List<Book> books;

    private static Long nextId = 4L;

    public MemoryBookService() {
        books = new ArrayList<>();
        books.add(new Book(1L,"1234567890123","Thinking in Java", "Bruce Eckel", "Helion", " programming"));
        books.add(new Book(2L,"1234567890231","Java", "Bruce Eckel, Jhonny Depp", "Helion", " programming"));
        books.add(new Book(3L,"1234567890321","Thinking", "Bruce Eckel", "Helion", " programming"));
    }

    public List<Book> getBooks() {
        return books;
    }

    @Override
    public void add(Book book) {
        book.setId(nextId++);
        books.add(book);
    }

    @Override
    public Optional<Book> get(Long id) {
        return books.stream().filter(item -> item.getId().equals(id)).findFirst();
    }

    @Override
    public void delete(Long id) {
        if(get(id).isPresent()){
            books.remove(this.get(id).get());
        }
    }

    @Override
    public void update(Book book) {
        if(this.get(book.getId()).isPresent()){
            int indexOf = books.indexOf(this.get(book.getId()).get());
            books.set(indexOf,book);
        }
    }


    public void setBooks(List<Book> books) {
        this.books = books;
    }
}

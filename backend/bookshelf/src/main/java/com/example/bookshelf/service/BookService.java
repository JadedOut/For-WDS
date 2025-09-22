package com.example.bookshelf.service;

import com.example.bookshelf.dto.Book;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class BookService {
    private final List<Book> books;
    private final Random random;
    
    public BookService() {
        this.random = new Random();
        this.books = initializeBooks();
    }
    
    private List<Book> initializeBooks() {
        List<Book> bookList = new ArrayList<>();
        
        // i swear i've read more books than this but im done having my fun
        bookList.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", 8, 
            "was forced to read it in grade 12 IB english, rated highly because i did good on the essay assigned to this lol "));
        bookList.add(new Book("The Little Prince", "Antoine de Saint-Exupery", 10, 
            "very nice lessons learned from this book and lowkey related to main character"));
        bookList.add(new Book("Animal Farm", "George Orwell", 9, 
            "a classic, was very eyeopening to a grade 9 me"));
        bookList.add(new Book("The Catcher in the Rye", "J.D. Salinger", 5, 
            "snoozefest of a book"));
        bookList.add(new Book("The Problem of the Puer Aeternus", "Marie-Louise Von Franz", 10, 
            "written for therapists, explores psychology behind the child-god complex"));
        bookList.add(new Book("The Hobbit", "J.R.R. Tolkien", 8, 
            "too small to remember how good it was, but i liked the story"));
        bookList.add(new Book("Dune", "Frank Herbert", 9, 
            "very nice worldbuilding"));
        
        return bookList;
    }
    
    public Book getRandomBook() {
        if (books.isEmpty()) {
            throw new RuntimeException("No books available in the collection");
        }
        
        int randomIndex = random.nextInt(books.size());
        return books.get(randomIndex);
    }
    
    public List<Book> getAllBooks() {
        return new ArrayList<>(books); // Return copy of books so u cant nuke the master list but ig user can still nuke their own
    }
}
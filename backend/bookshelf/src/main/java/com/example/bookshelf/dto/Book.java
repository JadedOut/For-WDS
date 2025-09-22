package com.example.bookshelf.dto;

public class Book {
    private String title;
    private String author;
    private int rating;
    private String review;
    
    public Book(String title, String author, int rating, String review) {
        this.title = title;
        this.author = author;
        this.rating = rating;
        this.review = review;
    }
    
    // Get
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getRating() { return rating; }
    public String getReview() { return review; }
    
    // Set
    public void setTitle(String title) { this.title = title; }
    public void setAuthor(String author) { this.author = author; }
    public void setRating(int rating) { this.rating = rating; }
    public void setReview(String review) { this.review = review; }
    
    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", rating=" + rating +
                ", review='" + review + '\'' +
                '}';
    }
}
package com.grinyov.library.entity;

/**
 * Book 
 */
public class Book implements java.io.Serializable {
private Long id;
    private Author author;
    private Genre genre;
    private Publisher publisher;
    private String name;
    private byte[] content;
    private int pageCount;
    private String isbn;
    private int publishYear;
    private byte[] image;
    private String descr;
    
    public Book() {
    }
    
    public Book(Publisher publisher) {
        this.publisher = publisher;
    }
    
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Author getAuthor() {
        return this.author;
    }
    
    public void setAuthor(Author author) {
        this.author = author;
    }
    
    public Genre getGenre() {
        return this.genre;
    }
    
    public void setGenre(Genre genre) {
        this.genre = genre;
    }
    
    public Publisher getPublisher() {
        return this.publisher;
    }
    
    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public byte[] getContent() {
        return this.content;
    }
    
    public void setContent(byte[] content) {
        this.content = content;
    }
    
    public int getPageCount() {
        return this.pageCount;
    }
    
    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    
    public String getIsbn() {
        return this.isbn;
    }
    
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    
    public int getPublishYear() {
        return this.publishYear;
    }
    
    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }
    
    public byte[] getImage() {
        return this.image;
    }
    
    public void setImage(byte[] image) {
        this.image = image;
    }
    
    public String getDescr() {
        return this.descr;
    }
    
    public void setDescr(String descr) {
        this.descr = descr;
    }
}

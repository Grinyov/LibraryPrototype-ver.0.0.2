package com.grinyov.library.beans;

import java.io.Serializable;

/**
 * Created by green on 15.10.2015.
 */
public class Book implements Serializable {

    private long id;        // уникальный номер книги
    private String name;    // название
    private byte[] content;// pdf файла загружаем в это поле только в нужный момент (для просмотра)
    private int pageCount; // кол-во страниц
    private String isbn;   // ISBN
    private String genre;   // Жанр книги
    private String author;  // автор
    private int publishDate;// дата публикации
    private String publisher;// издатель
    private byte[] image;   // обложка
    private String descr;   // краткое описание

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(int publishDate) {
        this.publishDate = publishDate;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }
}

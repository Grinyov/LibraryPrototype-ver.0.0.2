package com.grinyov.library.beans;


import com.grinyov.library.entity.ext.BookExt;

import javax.faces.bean.SessionScoped;
import java.util.List;

@SessionScoped
public class Pager {

    private static Pager pager;

    public Pager() {
    }
    
    private int totalBooksCount;
    private BookExt selectedBook;
    private List<BookExt> list;
    private int from;
    private int to;

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public List<BookExt> getList() {
        return list;
    }

    public void setList(List<BookExt> list) {
        this.list = list;
    }

    public void setTotalBooksCount(int totalBooksCount) {
        this.totalBooksCount = totalBooksCount;
    }

    public int getTotalBooksCount() {
        return totalBooksCount;
    }

    public BookExt getSelectedBook() {
        return selectedBook;
    }

    public void setSelectedBook(BookExt selectedBook) {
        this.selectedBook = selectedBook;
    }


}
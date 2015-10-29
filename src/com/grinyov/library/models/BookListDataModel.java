package com.grinyov.library.models;

import com.grinyov.library.beans.Pager;
import com.grinyov.library.dao.Dao;
import com.grinyov.library.entity.Book;

import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;


/**
 * Created by green on 29.10.2015.
 */



public class BookListDataModel extends LazyDataModel<Book> {  
    
    private List<Book> bookList;
    private Dao dao = Dao.getInstance();
    private Pager pager = Pager.getInstance();

    public BookListDataModel() {
        
    }

    @Override  
    public Book getRowData(String rowKey) {      
        
        for(Book book : bookList) {  
            if(book.getId().intValue() == Long.valueOf(rowKey).intValue())  
                return book;  
        }  
  
        return null;  
    }  
  
    @Override  
    public Object getRowKey(Book book) {  
        return book.getId();  
    }  

    @Override
    public List<Book> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,String> filters) {
        
        pager.setFrom(first);
        pager.setTo(pageSize);
     
        dao.populateList();

        this.setRowCount(pager.getTotalBooksCount());  
       
        
        return pager.getList();
        
    }  
}  

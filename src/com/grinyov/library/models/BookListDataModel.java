package com.grinyov.library.models;

import com.grinyov.library.beans.Pager;
import com.grinyov.library.dao.Dao;
import com.grinyov.library.entity.ext.BookExt;

import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;


/**
 * Created by green on 29.10.2015.
 */



public class BookListDataModel extends LazyDataModel<BookExt> {  
    
    private List<BookExt> bookList;
    private Dao dao;
    private Pager pager;

    public BookListDataModel(Dao dataHelper, Pager pager) {
        this.dao = dataHelper;
        this.pager = pager;
    }
    
    
    @Override  
    public BookExt getRowData(String rowKey) {      
        
        for(BookExt book : bookList) {  
            if(book.getId().intValue() == Long.valueOf(rowKey).intValue())  
                return book;  
        }  
  
        return null;  
    }  
  
    @Override  
    public Object getRowKey(BookExt book) {  
        return book.getId();  
    }  

    
    
  
    @Override  
    public List<BookExt> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,String> filters) {   
        
        pager.setFrom(first);
        pager.setTo(pageSize);
     
        dao.populateList();

        this.setRowCount(pager.getTotalBooksCount());  
        
        return pager.getList();
        
    }  
}  

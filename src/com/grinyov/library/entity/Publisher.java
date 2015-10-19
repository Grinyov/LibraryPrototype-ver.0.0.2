package com.grinyov.library.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 */
public class Publisher  implements java.io.Serializable {


     private Long id;
     private String name;
     private Set books = new HashSet(0);

    public Publisher() {
    }

	
    public Publisher(String name) {
        this.name = name;
    }
    public Publisher(String name, Set books) {
       this.name = name;
       this.books = books;
    }
   
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public Set getBooks() {
        return this.books;
    }
    
    public void setBooks(Set books) {
        this.books = books;
    }




}


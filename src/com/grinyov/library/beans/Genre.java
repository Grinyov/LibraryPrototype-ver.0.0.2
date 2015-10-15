package com.grinyov.library.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

/**
 * Created by Grinyov Vitaliy on 15.10.15.
 *
 * Класс, представляющий жанры нашей библиотеки
 */

@ManagedBean
@SessionScoped
public class Genre implements Serializable{

    private String name;
    private long id;

    public Genre() {
    }

    public Genre(String name, long id) {
        this.name = name;
        this.id = id;
    }

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

}
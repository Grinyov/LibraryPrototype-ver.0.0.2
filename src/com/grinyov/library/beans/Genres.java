package com.grinyov.library.beans;

import com.grinyov.library.dao.Dao;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Created by Grinyov Vitaliy on 15.10.15.
 *
 * Класс отвечающий за список жанров
 */
@ManagedBean
@ApplicationScoped
public class Genres implements Serializable{

    private ArrayList<Genre> genreList = new ArrayList<Genre>();

    private ArrayList<Genre> getGenres() {
        Statement stmt = null;
        ResultSet rs = null;
        Connection conn = null;
        try {
            conn = Dao.getConnection();

            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from genre order by name");
            while (rs.next()) {
                Genre genre = new Genre();
                genre.setName(rs.getString("name"));
                genre.setId(rs.getLong("id"));
                genreList.add(genre);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Genres.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (rs != null) {
                    rs.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Genres.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return genreList;
    }

    public ArrayList<Genre> getGenreList() {
        System.out.println("asdasd");
        if (!genreList.isEmpty()) {
            return genreList;
        } else {
            return getGenres();
        }
    }
}

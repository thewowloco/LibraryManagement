/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mtd.services;

import com.mtd.pojo.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dungm
 */
public class BookServices {
    
    private static final Connection conn = Utils.getConn();
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    
    public static List<Book> getBooks () {
        List<Book> listBook = new ArrayList<>();
        
        try {   
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("Select * From Books");

            while (rs.next()) {
                int bookID = rs.getInt("BookID");
                String name = rs.getString("BookName");
                String category = rs.getString("Category");
                String description = rs.getString("Description");
                Date publishYear = rs.getDate("PublishYear");
                String publishCompany = rs.getString("PublishCompany");
                Date entryDate = rs.getDate("EntryDate");
                String position = rs.getString("BookPosition");
                Book b = new Book(bookID, name, category, description, publishYear, publishCompany, entryDate, position);

                listBook.add(b);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(BookServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listBook;
    }
    
    public static Book getBookById(int bookID) {
        Book book1 = null;
        
        try {
            PreparedStatement stm = conn.prepareStatement("SELECT * FROM Books WHERE BookID = ?");
            stm.setInt(1, bookID);
            
            ResultSet rs = stm.executeQuery();
            
            while(rs.next()) {
                int id = rs.getInt("BookID");
                String name = rs.getString("BookName");
                String category = rs.getString("Category");
                String description = rs.getString("Description");
                Date publishYear = rs.getDate("PublishYear");
                String publishCompany = rs.getString("PublishCompany");
                Date entryDate = rs.getDate("EntryDate");
                String position = rs.getString("BookPosition");
                Book b = new Book(bookID, name, category, description, publishYear, publishCompany, entryDate, position);
                return b;

            }
            
        } catch (SQLException ex) {
            Logger.getLogger(BookServices.class.getName()).log(Level.SEVERE, null, ex);
        }
                        
        return book1;
    }
    
    public static boolean addBook(Book book) {
        boolean flag = false;
        try {
            
            String addQuery = "INSERT INTO Books(BookName, Category, Description,PublishYear, PublishCompany, EntryDate, BookPosition)"
                    + " VALUES(?, ?, ?, ?, ?, ?, ?);";    
            PreparedStatement stm = conn.prepareStatement(addQuery);           
            conn.setAutoCommit(flag);
            
            stm.setString(1, book.getBookName());
            stm.setString(2, book.getCategory());
            stm.setString(3, book.getDescription());
            stm.setDate(4, new java.sql.Date(book.getPublishYear().getTime()));
            stm.setString(5, book.getPublishCompany());
            stm.setDate(6, new java.sql.Date(book.getEntryDate().getTime()));
            stm.setString(7, book.getBookPosition());
            
            stm.executeUpdate();
            conn.commit();
            

            
            flag = true;
        } catch (SQLException ex) {
            Logger.getLogger(BookServices.class.getName()).log(Level.SEVERE, null, ex);
            if (conn != null)
                try {
                    System.err.print("Them du lieu bi loi. Rollback!");
                    conn.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(BookServices.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        
        
        return flag;
    }
}

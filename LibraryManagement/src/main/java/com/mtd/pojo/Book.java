/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mtd.pojo;

import com.mtd.pojo.Author;
import java.util.Date;
import java.util.List;

/**
 *
 * @author dungm
 */

public class Book {
    enum Category {
        VANHOC("Văn học"), KINHTE("Kinh tế"), KYNANG("Kỹ năng"), THIEUNHI("Thiếu nhi"),
        NGOAINGU("Ngoại ngữ"), KYTHUAT("Kỹ thuật");
        
        private String value;
        
        private Category(String value) {
            this.value = value;
        }
    
}
    private int bookID;
    private String bookName;
    private String category;
    private List<Author> authors;
    private String description = null;
    private Date publishYear = null;
    private String publishCompany = null;
    private Date entryDate = null;
    private String bookPosition = null;

    public Book(int bookID, String bookName, String category) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.category = category;  
    }
    
    /**
     * @return the bookID
     */
    public int getBookID() {
        return bookID;
    }

    /**
     * @param bookID the bookID to set
     */
    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    /**
     * @return the bookName
     */
    public String getBookName() {
        return bookName;
    }

    /**
     * @param bookName the bookName to set
     */
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    /**
     * @return the authors
     */
    public List<Author> getAuthors() {
        return authors;
    }

    /**
     * @param authors the authors to set
     */
    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    /**
     * @return the publishYear
     */
    public Date getPublishYear() {
        return publishYear;
    }

    /**
     * @param publishYear the publishYear to set
     */
    public void setPublishYear(Date publishYear) {
        this.publishYear = publishYear;
    }

    /**
     * @return the publishCompany
     */
    public String getPublishCompany() {
        return publishCompany;
    }

    /**
     * @param publishCompany the publishCompany to set
     */
    public void setPublishCompany(String publishCompany) {
        this.publishCompany = publishCompany;
    }

    /**
     * @return the entryDate
     */
    public Date getEntryDate() {
        return entryDate;
    }

    /**
     * @param entryDate the entryDate to set
     */
    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    /**
     * @return the bookPosition
     */
    public String getBookPosition() {
        return bookPosition;
    }

    /**
     * @param bookPosition the bookPosition to set
     */
    public void setBookPosition(String bookPosition) {
        this.bookPosition = bookPosition;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(String.format(" - ID: %d", this.getBookID()));
        str.append(String.format(" - Name: %s", this.getBookName()));
        str.append(String.format(" - Category: %s", this.getCategory()));
        
        return str.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
}

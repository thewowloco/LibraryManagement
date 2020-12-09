package com.mtd.librarymanagement;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import com.mtd.pojo.*;
import com.mtd.services.*;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
//        List<Book> ds = new ArrayList<>();
//        ds = BookServices.getBooks();
//        
//        for (Book i : ds) {
//            System.out.println(i.toString());
//            System.out.println("");
//        }

//        Book b1 = BookServices.getBookById(1);
//        System.out.println(b1.toString());

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

         Book abc;
        try {
            abc = new Book("Think and grow rich", Book.Category.KINHTE.getValue(),
                    "Đây là một cuốn sách kinh tế giá 110k", dateFormat.parse("1976-3-14"),
                    "Nhà xuất bản Lao Động", dateFormat.parse("2018-6-5"), "123");
            System.out.println(abc.getCategory());
            //BookServices.addBook(abc);
        } catch (ParseException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        
        System.out.println("OK!");
        //launch();
    }

}
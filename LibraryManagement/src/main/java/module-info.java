module com.mtd.librarymanagement {
    requires javafx.controls;
    requires javafx.fxml;
requires java.sql;
    opens com.mtd.librarymanagement to javafx.fxml;
    exports com.mtd.librarymanagement;
    
    
    
}

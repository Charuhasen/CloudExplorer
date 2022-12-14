module com.mycompany.cloudexplorer {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.base;
    requires javafx.graphics;

    opens com.mycompany.cloudexplorer to javafx.fxml;
    exports com.mycompany.cloudexplorer;
}

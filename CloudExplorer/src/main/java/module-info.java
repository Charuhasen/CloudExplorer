module com.mycompany.cloudexplorer {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.cloudexplorer to javafx.fxml;
    exports com.mycompany.cloudexplorer;
}

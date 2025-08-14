module com.example.exercise13 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens com.example.exercise13 to javafx.fxml;
    exports com.example.exercise13;
}
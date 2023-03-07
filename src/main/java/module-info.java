module com.gektokot.javanotes {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.gektokot.javanotes to javafx.fxml;
    exports com.gektokot.javanotes;
}
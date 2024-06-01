module com.mycompany.proyectosemestreprograi {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.base;

    opens com.mycompany.proyectosemestreprograi to javafx.fxml;
    exports com.mycompany.proyectosemestreprograi;
}

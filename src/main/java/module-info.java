module com.example.practica_5_ejer_1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;


    opens com.example.practica_5_ejer_2 to javafx.fxml;
    exports com.example.practica_5_ejer_2;
}
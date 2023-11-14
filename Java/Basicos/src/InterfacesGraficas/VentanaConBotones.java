package InterfacesGraficas;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class VentanaConBotones extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        primaryStage.setTitle("Ventana con Botones");

        // Crear un botón
        Button btn = new Button();
        btn.setText("Haz clic");

        // Establecer una acción al hacer clic en el botón
        btn.setOnAction(e -> System.out.println("¡Has hecho clic!"));

        // Crear un diseño para la escena
        StackPane root = new StackPane();
        root.getChildren().add(btn);

        // Crear la escena
        Scene scene = new Scene(root, 300, 250);

        // Establecer la escena en la ventana principal
        primaryStage.setScene(scene);

        // Mostrar la ventana
        primaryStage.show();
    }
}

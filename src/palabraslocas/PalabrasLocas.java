/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package palabraslocas;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author usuario
 */
public class PalabrasLocas extends Application {
    public static Stage stage;
    
    public void init(Stage primaryStage) throws IOException{
        primaryStage.initStyle(StageStyle.UNDECORATED);
        
        Parent root = FXMLLoader.load(getClass().getResource("Sample.fxml"));
        Scene scene = new Scene(root);   
        primaryStage.setScene(scene);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        stage=primaryStage;
        stage.initStyle(StageStyle.UNDECORATED);
        init(stage);
        stage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
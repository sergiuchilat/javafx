package app.core;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

abstract public class View {
    public void loadView(Stage stage, String viewName){
        try {
            String path = viewName + "View.fxml";
            Parent root = FXMLLoader.load(getClass().getResource(path));
            stage.setTitle("Java APP");
            stage.setScene(new Scene(root, 600, 875));
            stage.show();
        } catch(Exception e) {
            System.out.println("Load exception");
            System.out.println(e.toString());
        }
    }
}

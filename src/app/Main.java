package app;

import javafx.application.Application;
import javafx.stage.Stage;
import app.modules.auth.LoginFormView;

public class Main extends Application {

    LoginFormView loginFormView = new LoginFormView();

    @Override
    public void start(Stage primaryStage) {
        loginFormView.loadView(primaryStage, "LoginForm");
    }

    public static void main(String[] args) {
        launch(args);
    }
}

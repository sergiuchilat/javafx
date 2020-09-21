package app;

import app.modules.students.StudentListView;
import javafx.application.Application;
import javafx.stage.Stage;
import app.modules.auth.LoginFormView;

public class Main extends Application {

    LoginFormView loginFormView = new LoginFormView();
    StudentListView mainPageView = new StudentListView();

    @Override
    public void start(Stage primaryStage) {
        loginFormView.loadView(primaryStage, "LoginForm");
//        mainPageView.loadView(primaryStage, "MainPage");
    }

    public static void main(String[] args) {
        launch(args);
    }
}

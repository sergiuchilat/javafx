package app.modules.auth;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import app.core.View;
import app.modules.main.MainPageView;


public class LoginFormView extends View{

    @FXML
    private JFXTextField usernameInput;

    @FXML
    private JFXTextField passwordInput;

    @FXML
    private JFXButton loginButton;

    @FXML
    private Label authResponseStatusLabel;

    private MainPageView mainPageView;

    @FXML
    public void initialize(){
        LoginFormViewModel loginFormViewModel = new LoginFormViewModel();
        usernameInput.textProperty().bindBidirectional(loginFormViewModel.getUsername());
        passwordInput.textProperty().bindBidirectional(loginFormViewModel.getPassword());
        authResponseStatusLabel.setText("");
        loginFormViewModel.getUsername().setValue("admin");
        loginFormViewModel.getPassword().setValue("1234");

        loginButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent mouseEvent) {
                Stage mainStage = (Stage) loginButton.getScene().getWindow();
                authResponseStatusLabel.setText("");
                if(loginFormViewModel.login()){
                    mainPageView = new MainPageView();
                    mainPageView.loadView(mainStage, "MainPage");
                    authResponseStatusLabel.setText("Success");
                } else {
                    authResponseStatusLabel.setText("Incorrect login or password");
                }
            }
        });
    }
}

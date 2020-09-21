package app.modules.auth;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import app.core.View;
import app.modules.students.main.StudentListView;


public class LoginFormView extends View{

    @FXML
    private JFXTextField usernameInput;

    @FXML
    private JFXTextField passwordInput;

    @FXML
    private JFXButton loginButton;

    @FXML
    private Label authResponseStatusLabel;

    private StudentListView mainPageView;

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
                login(loginFormViewModel);
            }
        });

        usernameInput.setOnKeyReleased(event -> {
            if(event.getCode() == KeyCode.ENTER){
                try {
                    login(loginFormViewModel);
                } catch (Exception e){
                    System.out.println(e.toString());
                }
            }
        });

        passwordInput.setOnKeyReleased(event -> {
            if(event.getCode() == KeyCode.ENTER){
                try {
                    login(loginFormViewModel);
                } catch (Exception e){
                    System.out.println(e.toString());
                }
            }
        });
    }

    private void login(LoginFormViewModel loginFormViewModel){
        Stage mainStage = (Stage) loginButton.getScene().getWindow();
        authResponseStatusLabel.setText("");
        if(loginFormViewModel.login()){
            mainPageView = new StudentListView();
            mainPageView.loadView(mainStage, "StudentList");
            authResponseStatusLabel.setText("Success");
        } else {
            authResponseStatusLabel.setText("Incorrect login or password");
        }
    }
}

package app.modules.auth;

import app.core.exceptions.MyAuthorizationErrorException;
import app.core.exceptions.MyNetworkErrorException;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import app.core.View;
import app.modules.students.StudentListView;


public class LoginFormView extends View{

    @FXML
    private JFXTextField usernameInput;

    @FXML
    private JFXTextField passwordInput;

    @FXML
    private JFXButton loginButton;

    @FXML
    private Label authResponseStatusLabel;

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
                usernameInput.setEditable(false);
                passwordInput.setEditable(false);
                loginButton.setDisable(true);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    login(loginFormViewModel);
                } catch (MyAuthorizationErrorException e) {
                    System.out.println(e.toString());
                    usernameInput.setStyle("-fx-text-inner-color: red");
                    passwordInput.setStyle("-fx-text-inner-color: red");
                } catch (MyNetworkErrorException e) {
                    System.out.println(e.toString());
                    usernameInput.setStyle("-fx-text-inner-color: red");
                    passwordInput.setStyle("-fx-text-inner-color: red");
                } finally {
                    usernameInput.setEditable(true);
                    passwordInput.setEditable(true);
                    loginButton.setDisable(false);
                }
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

    private void login(LoginFormViewModel loginFormViewModel) throws MyNetworkErrorException, MyAuthorizationErrorException {
        Stage mainStage = (Stage) loginButton.getScene().getWindow();
        authResponseStatusLabel.setText("");
        if(loginFormViewModel.login()){
            StudentListView mainPageView = new StudentListView();
            mainPageView.loadView(mainStage, "StudentList");
            authResponseStatusLabel.setText("Success");
            usernameInput.setStyle("-fx-text-inner-color: green");
            passwordInput.setStyle("-fx-text-inner-color: green");
        } else {
            authResponseStatusLabel.setText("Incorrect login or password");
            usernameInput.setStyle("-fx-text-inner-color: red");
            passwordInput.setStyle("-fx-text-inner-color: red");
        }
    }
}

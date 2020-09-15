package app.modules.main;

import app.core.View;
import app.modules.auth.LoginFormView;
import app.modules.auth.LoginFormViewModel;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MainPageView extends View{
    @FXML
    private Button backToLoginBtn;

    private LoginFormView loginFormView;

    @FXML
    public void initialize(){

        backToLoginBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent mouseEvent) {
                Stage mainStage = (Stage) backToLoginBtn.getScene().getWindow();
                loginFormView = new LoginFormView();
                loginFormView.loadView(mainStage, "LoginForm");
            }
        });
    }
}

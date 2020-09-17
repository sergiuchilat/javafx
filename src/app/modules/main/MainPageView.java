package app.modules.main;

import app.core.View;
import app.modules.auth.LoginFormView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import app.models.Student;

public class MainPageView extends View{
    @FXML
    private Button backToLoginBtn;

    @FXML
    private TableView tableView;

    private LoginFormView loginFormView;
    MainPageViewModel mainPageViewModel;


    @FXML
    public void initialize(){
        mainPageViewModel = new MainPageViewModel();
        backToLoginBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent mouseEvent) {
                Stage mainStage = (Stage) backToLoginBtn.getScene().getWindow();
                loginFormView = new LoginFormView();
                loginFormView.loadView(mainStage, "LoginForm");
            }
        });

        ObservableList<Student> students = FXCollections.observableArrayList();

        tableView = new TableView<Student>();

        students.add(new Student("Mihai Eminescu", 123));
        students.add(new Student("Ion Creanga", 123));
        System.out.println(students);

        tableView.setItems(students);

    }
}

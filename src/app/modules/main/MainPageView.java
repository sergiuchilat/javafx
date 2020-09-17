package app.modules.main;

import app.core.View;
import app.models.StudentModel;
import app.modules.auth.LoginFormView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Popup;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MainPageView extends View implements Initializable {
    @FXML
    private Button backToLoginBtn;

    @FXML
    private Button createBtn;

    @FXML
    private TableView<StudentModel> tableView;

    @FXML
    public TableColumn<StudentModel, Integer> studentId;
    @FXML
    public TableColumn<StudentModel, String> studentName;
    @FXML
    public TableColumn<StudentModel, Integer> studentAge;

    private LoginFormView loginFormView;
    MainPageViewModel mainPageViewModel;


    private final ObservableList<StudentModel> students = FXCollections.observableArrayList(
            new StudentModel("Amos", 12),
            new StudentModel("Keep", 23)
    );

    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        mainPageViewModel = new MainPageViewModel();

        backToLoginBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Stage mainStage = (Stage) backToLoginBtn.getScene().getWindow();
                loginFormView = new LoginFormView();
                loginFormView.loadView(mainStage, "LoginForm");
            }
        });

        createBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Stage mainStage = (Stage) backToLoginBtn.getScene().getWindow();
                Popup createPopup = new Popup();
                TextField nameInput = new TextField();
                nameInput.setText("Name");
                createPopup.getContent().add(nameInput);
                createPopup.show(mainStage);
            }
        });


        try{
            studentId.setCellValueFactory(new PropertyValueFactory<>("Id"));
            studentName.setCellValueFactory(new PropertyValueFactory<>("Name"));
            studentAge.setCellValueFactory(new PropertyValueFactory<>("Age"));
            tableView.setItems(students);
        } catch (Exception e) {
            System.out.println(e);
        }

        //System.out.println(students);

    }
}

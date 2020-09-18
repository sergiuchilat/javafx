package app.modules.students.main;

import app.core.View;
import app.models.StudentModel;
import app.modules.auth.LoginFormView;
import app.modules.students.create.StudentCreateDialogView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StudentListView extends View implements Initializable {
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
    StudentListViewModel mainPageViewModel;


    private final ObservableList<StudentModel> students = FXCollections.observableArrayList(
            new StudentModel("Amos", 12),
            new StudentModel("Keep", 23)
    );

    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        mainPageViewModel = new StudentListViewModel();

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
    }
    @FXML
    void onOpenCreateDialog(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../create/StudentCreateDialogView.fxml"));
        Parent parent = fxmlLoader.load();
        StudentCreateDialogView createDialogView = fxmlLoader.<StudentCreateDialogView>getController();
        createDialogView.setAppMainObservableList(students);

        Scene scene = new Scene(parent, 300, 200);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.showAndWait();
    }
}

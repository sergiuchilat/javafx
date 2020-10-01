package app.modules.students;

import app.models.StudentModel;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.Collections;

public class StudentCreateDialogView {

    @FXML
    private TextField studentNameInput;

    @FXML
    private TextField studentAgeInput;

    private ObservableList<StudentModel> appMainObservableList;
    private final StudentsRepository studentsRepository = new StudentsRepository();

    @FXML
    void btnAddClicked(ActionEvent event) {
        String studentName = "";
        int studentAge = 0;
        try {
            studentName = studentNameInput.getText().trim();
            studentAge = Integer.parseInt(studentAgeInput.getText().trim());
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        if(studentName.length() > 0 &&studentAge > 0) {
            StudentModel data = new StudentModel(studentName, studentAge);
            //appMainObservableList.add(data);
            studentsRepository.create(data);
            appMainObservableList.clear();
            Collections.addAll(appMainObservableList, studentsRepository.getAll());
            closeStage(event);
        }
    }

    public void setAppMainObservableList(ObservableList<StudentModel> tvObservableList) {
        this.appMainObservableList = tvObservableList;

    }

    private void closeStage(ActionEvent event) {
        Node  source = (Node)  event.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
    }

}
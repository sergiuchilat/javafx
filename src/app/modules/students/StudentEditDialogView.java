package app.modules.students;

import app.models.StudentModel;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class StudentEditDialogView {

    @FXML
    private TextField studentNameInput;

    @FXML
    private TextField studentAgeInput;

    private ObservableList<StudentModel> appMainObservableList;

    private Integer selectedIndex;
    private StudentModel selectedItem;

    @FXML
    void btnUpdateClicked(ActionEvent event) {
        String studentName = "";
        int studentAge = 0;
        try {
            studentName = studentNameInput.getText().trim();
            studentAge = Integer.parseInt(studentAgeInput.getText().trim());
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        if(studentName.length() > 0 &&studentAge > 0) {
            appMainObservableList.set(selectedIndex, new StudentModel(studentNameInput.getText(), Integer.valueOf(studentAgeInput.getText())));
            closeStage(event);
        }
    }

    @FXML
    void btnDeleteClicked(ActionEvent event){
        appMainObservableList.remove(selectedItem);
        closeStage(event);
    }

    public void setAppMainObservableList(ObservableList<StudentModel> tvObservableList) {
        this.appMainObservableList = tvObservableList;
    }

    public void setSelectedItem(StudentModel selectedItem){
        this.selectedItem = selectedItem;
        this.selectedIndex = appMainObservableList.indexOf(selectedItem);
        this.studentAgeInput.setText(selectedItem.getAge().toString());
        this.studentNameInput.setText(selectedItem.getName());
    }

    private void closeStage(ActionEvent event) {
        Node  source = (Node)  event.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
    }
}
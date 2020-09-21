package app.modules.students;

import app.models.StudentModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class StudentListViewModel {
    private final ObservableList<StudentModel> students = FXCollections.observableArrayList(
            new StudentModel("Ion Creanga", 12),
            new StudentModel("Mihai Eminescu", 23),
            new StudentModel("Vasile Alecsandri", 34)
    );

    public ObservableList<StudentModel> getStudents() {
        return students;
    }

}

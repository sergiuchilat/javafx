package app.modules.students;

import app.models.StudentModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class StudentListViewModel {
    StudentsRepository studentsRepository = new StudentsRepository();
    private final ObservableList<StudentModel> students = FXCollections.observableArrayList(studentsRepository.getAll());

    public ObservableList<StudentModel> getStudents() {
        return students;
    }
}

package app.modules.students;

import app.models.Student;
import app.models.StudentModel;

import java.util.Arrays;

public class StudentsRepository {
    StudentModel[] students = new StudentModel[50];


    public StudentModel[] getAll(){
        System.out.println(Arrays.toString(students));
        if(students[0] == null){
            students[0] = new StudentModel("Ion Creanga", 12);
            students[1] = new StudentModel("Mihai Eminescu", 23);
            students[2] = new StudentModel("Vasile Alecsandri", 34);
        }
        return students;
    }

    public StudentModel create(StudentModel studentModel){
        students[StudentModel.counter - 2] = studentModel;
        return studentModel;
    }

    public StudentModel update(Integer id, StudentModel studentToUpdate){
        for (int i = 0; i < students.length; i++) {
            try{
                if (students[i].getId().equals(id)) {
                    students[i] = studentToUpdate;
                    return students[i];
                }
            } catch (Exception e) {
                return empty();
            }
        }
        return empty();
    }

    private StudentModel empty(){
        return new StudentModel("", 0);
    }
}

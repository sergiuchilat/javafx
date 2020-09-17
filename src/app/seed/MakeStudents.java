/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.seed;
import app.models.Student;

/**
 *
 * @author Sergiu
 */
public class MakeStudents {
    public static Student[] run(){
        Student[] students = new Student[50];
        for(int i = 0; i < 10; i++) {
            Student student = new Student("Student " + i, 10 + i);
            students[i]= student;           
        }
        return students;
    }
}

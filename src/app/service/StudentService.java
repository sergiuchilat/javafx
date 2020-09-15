package crud.service;

import crud.dao.StudentDAO;
import crud.model.Student;

public class StudentService implements IService<Student> {
    private final StudentDAO studentDAO = new StudentDAO();

    @Override
    public Student create(Student student) {
        return this.studentDAO.create(student);
    }
    @Override
    public Student read(Integer id) {
        return this.studentDAO.read(id);
    }
    @Override
    public Student[] read() {
        return this.studentDAO.read();
    }
    @Override
    public Student update(Integer id, Student studentToUpdate){
        return this.studentDAO.update(id, studentToUpdate);
    }
    @Override
    public boolean delete(Integer id){
        return this.studentDAO.delete(id);
    }
}

package app.modules.students;

public class StudentsRepository {
    public boolean login(String username, String password){
        return username.equals("admin") && password.equals("1234");
    }
}

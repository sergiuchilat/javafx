package app.modules.auth;

public class LoginRepository {
    public boolean login(String username, String password){
        return username.equals("admin") && password.equals("1234");
    }
}

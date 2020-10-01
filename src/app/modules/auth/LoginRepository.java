package app.modules.auth;

import app.core.exceptions.MyAuthorizationErrorException;
import app.core.exceptions.MyNetworkErrorException;

public class LoginRepository {
    public boolean login(String username, String password) throws MyNetworkErrorException, MyAuthorizationErrorException {
        if(username.isBlank()) {
            throw new MyAuthorizationErrorException("User name can not be blank");
        }
        if(username.equals("503")) {
            throw new MyNetworkErrorException("Service unavailable");
        }
        if(username.equals("404")) {
            throw new MyNetworkErrorException("404 Resource not found");
        }
        if(username.equals("403")) {
            throw new MyAuthorizationErrorException("403 Forbidden access");
        }
        return username.equals("admin") && password.equals("1234");
    }
}

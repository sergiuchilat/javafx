package app.modules.auth;

import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.beans.property.ReadOnlyBooleanWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LoginFormViewModel {
    private final StringProperty username = new SimpleStringProperty();
    private final StringProperty password = new SimpleStringProperty();
    private final ReadOnlyBooleanWrapper isLoginPossible = new ReadOnlyBooleanWrapper();

    private final LoginRepository loginRepository;

    LoginFormViewModel(){
        loginRepository = new LoginRepository();
    }

    public StringProperty getUsername(){
        return username;
    }

    public StringProperty getPassword() {
        return password;
    }

    public ReadOnlyBooleanProperty isLoginPossible() {
        return isLoginPossible.getReadOnlyProperty();
    }

    public boolean login(){
        if(username.getValueSafe().length() > 0 && password.getValueSafe().length() > 0) {
            return this.loginRepository.login(username.getValue(), password.getValue());
        }
        return false;
    }
}

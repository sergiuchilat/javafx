package app.core.exceptions;

public class MyAuthorizationErrorException extends RuntimeException{
    public MyAuthorizationErrorException(String message){
        super(message);
    }
}

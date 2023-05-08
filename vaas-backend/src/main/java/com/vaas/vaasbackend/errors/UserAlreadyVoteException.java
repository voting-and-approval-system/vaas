package com.vaas.vaasbackend.errors;

public class UserAlreadyVoteException extends Exception{
    public UserAlreadyVoteException() {
    }

    public UserAlreadyVoteException(String message) {
        super(message);
    }

    public UserAlreadyVoteException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserAlreadyVoteException(Throwable cause) {
        super(cause);
    }

    public UserAlreadyVoteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

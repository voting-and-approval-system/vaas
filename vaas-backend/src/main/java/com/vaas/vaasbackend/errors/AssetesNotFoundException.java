package com.vaas.vaasbackend.errors;

public class AssetesNotFoundException extends Exception{
    public AssetesNotFoundException() {
        super();
    }

    public AssetesNotFoundException(String message) {
        super(message);
    }

    public AssetesNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public AssetesNotFoundException(Throwable cause) {
        super(cause);
    }

    protected AssetesNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

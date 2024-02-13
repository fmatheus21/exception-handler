package com.fmatheus.app.controller.exception;

import com.fmatheus.app.controller.enumerable.MessagesEnum;

public class PasswordNotMatchException extends RuntimeException {

    public PasswordNotMatchException() {
        super(MessagesEnum.ERROR_PASSWORD_NOT_MATCH.getMessage());
    }
}

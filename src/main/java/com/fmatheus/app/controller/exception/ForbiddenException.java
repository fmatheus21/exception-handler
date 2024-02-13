package com.fmatheus.app.controller.exception;

import com.fmatheus.app.controller.enumerable.MessagesEnum;

public class ForbiddenException extends RuntimeException {

    public ForbiddenException() {
        super(MessagesEnum.ERROR_FORBIDDEN.getMessage());
    }

}
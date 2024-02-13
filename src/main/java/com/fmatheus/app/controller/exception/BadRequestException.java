package com.fmatheus.app.controller.exception;

import com.fmatheus.app.controller.enumerable.MessagesEnum;

public class BadRequestException extends RuntimeException {

    public BadRequestException(MessagesEnum messagesEnum) {
        super(messagesEnum.getMessage());
    }

}

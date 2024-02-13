package com.fmatheus.app.controller.exception.message;


import com.fmatheus.app.controller.enumerable.MessagesEnum;
import com.fmatheus.app.controller.exception.BadRequestException;
import com.fmatheus.app.controller.exception.ForbiddenException;
import com.fmatheus.app.controller.exception.PasswordNotMatchException;
import com.fmatheus.app.controller.exception.handler.MessageResponseHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Component
public class MessageResponse {

    private final MessageSource messageSource;

    private MessageResponseHandler messageResponse(MessagesEnum messagesEnum) {
        return new MessageResponseHandler(messagesEnum, messagesEnum.getHttpSttus().getReasonPhrase(),
                this.messageSource.getMessage(messagesEnum.getMessage(), null, LocaleContextHolder.getLocale()));
    }

    public MessageResponseHandler messageSuccessUpdate() {
        return this.messageResponse(MessagesEnum.SUCCESS_UPDATE);
    }

    public MessageResponseHandler messageSuccessCreate() {
        return this.messageResponse(MessagesEnum.SUCCESS_CREATE);
    }

    public MessageResponseHandler messageSuccessDelete() {
        return this.messageResponse(MessagesEnum.SUCCESS_DELETE);
    }

    public BadRequestException errorExistDocument() {
        return new BadRequestException(MessagesEnum.ERROR_EXIST_DOCUMENT);
    }

    public BadRequestException errorExistEmail() {
        return new BadRequestException(MessagesEnum.ERROR_EXIST_EMAIL);
    }

    public BadRequestException errorExistPhone() {
        return new BadRequestException(MessagesEnum.ERROR_EXIST_PHONE);
    }

    public BadRequestException errorRecordNotExist() {
        return new BadRequestException(MessagesEnum.ERROR_RECORD_NOT_EXIST);
    }

    public BadRequestException errorUserdNotExist() {
        return new BadRequestException(MessagesEnum.ERROR_USER_NOT_EXIST);
    }

    public BadRequestException errorExistRecord() {
        return new BadRequestException(MessagesEnum.ERROR_EXIST_RECORD);
    }

    public ForbiddenException errorForbidden() {
        return new ForbiddenException();
    }


    public PasswordNotMatchException errorPasswordNotMatchException() {
        return new PasswordNotMatchException();
    }
}

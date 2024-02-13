package com.fmatheus.app.controller.rule;


import com.fmatheus.app.controller.dto.request.ClientRequest;
import com.fmatheus.app.controller.dto.response.ClientResponse;
import com.fmatheus.app.controller.exception.handler.MessageResponseHandler;
import com.fmatheus.app.controller.exception.message.MessageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@RequiredArgsConstructor
@Component
public class ClientRule {

    private final MessageResponse message;

    public ClientResponse create(ClientRequest request) {
        var client = this.converterResponse(request);
        client.setMessage(this.message.messageSuccessCreate());
        return client;
    }

    public ClientResponse update(ClientRequest request, UUID id) {
        var client = this.converterResponse(request);
        client.setId(id);
        client.setMessage(this.message.messageSuccessUpdate());
        return client;
    }

    public MessageResponseHandler delete(UUID id) {
        return this.message.messageSuccessDelete();
    }

    private ClientResponse converterResponse(ClientRequest request) {
        return ClientResponse.builder()
                .id(UUID.randomUUID())
                .name(request.getName())
                .document(request.getDocument())
                .email(request.getEmail())
                .phone(request.getPhone())
                .build();
    }

    public MessageResponseHandler exception(String exception) {
        return switch (exception) {
            case "errorExistDocument" -> this.errorExistDocument();
            case "errorExistEmail" -> this.errorExistEmail();
            case "errorExistPhone" -> this.errorExistPhone();
            case "errorRecordNotExist" -> this.errorRecordNotExist();
            case "errorUserdNotExist" -> this.errorUserdNotExist();
            case "errorExistRecord" -> this.errorExistRecord();
            case "errorForbidden" -> this.errorForbidden();
            case "errorPasswordNotMatchException" -> this.errorPasswordNotMatchException();
            default -> null;
        };
    }


    private MessageResponseHandler errorExistDocument() {
        throw this.message.errorExistDocument();
    }

    private MessageResponseHandler errorExistEmail() {
        throw this.message.errorExistEmail();
    }

    private MessageResponseHandler errorExistPhone() {
        throw this.message.errorExistPhone();
    }

    private MessageResponseHandler errorRecordNotExist() {
        throw this.message.errorRecordNotExist();
    }

    private MessageResponseHandler errorUserdNotExist() {
        throw this.message.errorUserdNotExist();
    }

    private MessageResponseHandler errorExistRecord() {
        throw this.message.errorExistRecord();
    }

    private MessageResponseHandler errorForbidden() {
        throw this.message.errorForbidden();
    }

    private MessageResponseHandler errorPasswordNotMatchException() {
        throw this.message.errorPasswordNotMatchException();
    }

}

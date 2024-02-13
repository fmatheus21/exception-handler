package com.fmatheus.app.controller.dto.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fmatheus.app.controller.exception.handler.MessageResponseHandler;
import lombok.*;

import java.util.UUID;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientResponse {
    private UUID id;
    private String name;
    private String document;
    private String email;
    private String phone;
    private MessageResponseHandler message;
}

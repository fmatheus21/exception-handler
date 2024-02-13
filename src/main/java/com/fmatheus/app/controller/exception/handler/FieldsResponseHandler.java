package com.fmatheus.app.controller.exception.handler;


import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FieldsResponseHandler {
    private String field;
    private String message;
}

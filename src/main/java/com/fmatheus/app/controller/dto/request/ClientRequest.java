package com.fmatheus.app.controller.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientRequest {

    @NotBlank
    @Size(min = 5, max = 30)
    private String name;

    @NotBlank
    private String document;

    @NotBlank
    @Size(min = 5, max = 30)
    @Email
    private String email;

    @NotBlank
    private String phone;

}

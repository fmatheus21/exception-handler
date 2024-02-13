package com.fmatheus.app.controller.resource;


import com.fmatheus.app.controller.dto.request.ClientRequest;
import com.fmatheus.app.controller.dto.response.ClientResponse;
import com.fmatheus.app.controller.exception.handler.MessageResponseHandler;
import com.fmatheus.app.controller.rule.ClientRule;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/clients")
public class ClientResource {

    private final ClientRule rule;


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ClientResponse create(@RequestBody @Valid ClientRequest request) {
        return this.rule.create(request);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/{id}")
    public ClientResponse update(@RequestBody @Valid ClientRequest request, @PathVariable UUID id) {
        return this.rule.update(request, id);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public MessageResponseHandler delete(@PathVariable UUID id) {
        return this.rule.delete(id);
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public MessageResponseHandler exception(@RequestParam String exception) {
        return this.rule.exception(exception);
    }


}

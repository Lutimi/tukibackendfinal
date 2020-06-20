package com.acme.tukibackend.resource.account;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class SaveLoginResource {
    @NotNull
    @NotBlank
    private String email;

    @NotNull
    @NotBlank
    private String password;
}

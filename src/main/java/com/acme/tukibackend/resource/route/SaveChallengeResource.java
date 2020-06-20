package com.acme.tukibackend.resource.route;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class SaveChallengeResource {
    @NotNull
    @NotBlank
    @Size(max = 200)
    private String title;

    @NotNull
    @NotBlank
    @Size(max = 250)
    private String description;

    private Integer tukicoins;

    @NotNull
    @NotBlank
    private String address;

    @NotNull
    @NotBlank
    private String coordinates;
}

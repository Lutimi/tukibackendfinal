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

    @NotNull
    @NotBlank
    private Integer tukicoins;

    @NotNull
    @NotBlank
    private Double latitude;

    @NotNull
    @NotBlank
    private Double longitude;
}

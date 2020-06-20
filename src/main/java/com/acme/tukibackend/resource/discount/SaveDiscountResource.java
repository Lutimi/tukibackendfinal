package com.acme.tukibackend.resource.discount;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
public class SaveDiscountResource {
    @NotNull
    @NotBlank
    @Size(max = 200)
    private String name;

    @NotNull
    @NotBlank
    @Size(max = 250)
    private String description;

    @NotNull
    @NotBlank
    @Size(max = 250)
    private String terminos;
}

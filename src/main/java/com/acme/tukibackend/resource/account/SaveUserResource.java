package com.acme.tukibackend.resource.account;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

import javax.persistence.Column;
import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class SaveUserResource {
    @NotNull
    @NotBlank
    @Size(max = 200)
    @Column(unique = true)
    private String email;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private String firstName;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private String lastName;

    @NotNull
    @NotBlank
    private String password;

    //private Boolean enabled = true;
    //private String confirmationToken = "xx54545x465X4S54S5XSXDSFGX";

}

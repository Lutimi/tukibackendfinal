package com.acme.tukibackend.resource.account;

import com.acme.tukibackend.model.AuditModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResource extends AuditModel {
    private Long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private Integer tukicoins;
}

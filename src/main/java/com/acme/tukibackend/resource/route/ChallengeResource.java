package com.acme.tukibackend.resource.route;

import com.acme.tukibackend.model.AuditModel;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class ChallengeResource extends AuditModel {

    private Long id;
    private String title;
    private String description;
    private Integer tukicoins;
    private String address;
    private String coordinates;
    /*private Float latitude;

    private Float longitude;*/
}

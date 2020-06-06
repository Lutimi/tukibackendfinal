package com.acme.tukibackend.resource.route;

import com.acme.tukibackend.model.AuditModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class RouteResource extends AuditModel {
    private Long id;
    private String title;
    private String description;
    private String content;
}

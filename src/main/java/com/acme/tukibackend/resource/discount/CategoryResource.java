package com.acme.tukibackend.resource.discount;

import com.acme.tukibackend.model.AuditModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryResource extends AuditModel {
    private Long id;
    private String title;
    private String description;

}

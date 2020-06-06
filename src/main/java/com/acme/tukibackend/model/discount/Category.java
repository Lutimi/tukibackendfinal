package com.acme.tukibackend.model.discount;


import com.acme.tukibackend.model.AuditModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "categories")
@Getter
@Setter
public class Category extends AuditModel {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private String name;

    @NotNull
    @NotBlank
    @Size(max = 250)
    private String Description;









}

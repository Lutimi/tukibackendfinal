package com.acme.tukibackend.model.account;

import com.acme.tukibackend.model.AuditModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import java.util.Date;
@Entity
@Table(name = "UsersCompany")
@Getter
@Setter
public class UserCompany extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ruc", nullable = false, unique = true)
    @NotEmpty(message = "Please provide an Name")
    private String name;

    @NotEmpty(message = "Please provide your Ruc")
    private String ruc;



}

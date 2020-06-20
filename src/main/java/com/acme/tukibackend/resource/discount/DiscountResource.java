package com.acme.tukibackend.resource.discount;

import com.acme.tukibackend.model.AuditModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
public class DiscountResource extends AuditModel {
    private Long id;
    private String name;
    private String description;
    private String terminos;
    private Integer tukicoins;
    private Date startDate;
    private Date endDate;
}

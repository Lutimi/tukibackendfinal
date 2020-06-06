package com.acme.tukibackend.controller.discount;

import com.acme.tukibackend.model.discount.Discount;
import com.acme.tukibackend.resource.discount.DiscountResource;
import com.acme.tukibackend.resource.discount.SaveDiscountResource;
import com.acme.tukibackend.service.discount.DiscountService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
public class DiscountController {
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private DiscountService discountService;

    @GetMapping("/discounts")
    public Page<DiscountResource> getAllDiscounts(Pageable pageable) {
        List<DiscountResource> discounts = discountService.getAllDiscounts(pageable).getContent().stream().map(this::convertToResource).collect(Collectors.toList());
        int discountsCount = discounts.size();
        return new PageImpl<>(discounts, pageable, discountsCount);
    }

    @GetMapping("/discount/{id}")
    public DiscountResource getDiscountById(@PathVariable(name = "id") Long discountId) {
        return convertToResource(discountService.getDiscountById(discountId));
    }

    @PostMapping("/discount")
    public DiscountResource createDiscount(@Valid @RequestBody SaveDiscountResource resource) {
        return convertToResource(discountService.createDiscount(convertToEntity(resource)));
    }

    @PutMapping("/discounts/{id}")
    public DiscountResource updateDiscount(@PathVariable(name = "id") Long discountId, @Valid @RequestBody SaveDiscountResource resource) {
        return convertToResource(discountService.updateDiscount(discountId, convertToEntity(resource)));
    }


    private Discount convertToEntity(SaveDiscountResource resource) {
        return mapper.map(resource, Discount.class);
    }

    private DiscountResource convertToResource(Discount entity) {
        return mapper.map(entity, DiscountResource.class);
    }
}

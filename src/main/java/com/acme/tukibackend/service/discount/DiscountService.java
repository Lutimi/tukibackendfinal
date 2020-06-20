package com.acme.tukibackend.service.discount;

import com.acme.tukibackend.model.discount.Discount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DiscountService {
    Page<Discount> getAllDiscounts(Pageable pageable);
    Discount getDiscountById(Long discountId);
    Discount createDiscount(Long categoryId, Discount discountId);
    Discount updateDiscount(Long discountId, Discount discountDetails);
    }

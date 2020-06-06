package com.acme.tukibackend.service.discount;

import com.acme.tukibackend.exception.ResourceNotFoundException;
import com.acme.tukibackend.model.discount.Discount;
import com.acme.tukibackend.repository.discount.DiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DiscountServiceImpl implements DiscountService {

    @Autowired
    private DiscountRepository discountRepository;

    @Override
    public Discount getDiscountById(Long userId) {
        return discountRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Discount", "Id", userId));
    }

    @Override
    public Page<Discount> getAllDiscounts(Pageable pageable) {
        return discountRepository.findAll(pageable);
    }

    @Override
    public Discount createDiscount(Discount discount) {
        return discountRepository.save(discount);
    }

    @Override
    public Discount updateDiscount(Long discountId, Discount discountDetails) {
        return discountRepository.findById(discountId).map(discount -> {
            discount.setCategory(discountDetails.getCategory());
            discount.setDescription(discountDetails.getDescription());
            discount.setName(discountDetails.getName());
            discount.setStartDate(discountDetails.getStartDate());
            discount.setEndDate(discountDetails.getEndDate());
            discount.setTerminos(discountDetails.getTerminos());
            discount.setTukicoins(discountDetails.getTukicoins());
            return discountRepository.save(discount);
        }).orElseThrow(() -> new ResourceNotFoundException("Discount", "Id", discountId));
    }
}
